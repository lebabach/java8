package asyn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class DemoAsyn extends Thread {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		List<String> mailer = IntStream.range(1, 51).mapToObj(x -> "bach" + x + "@gmail.com")
				.collect(Collectors.toList());
		Supplier<List<String>> supplierMail = () -> mailer;
		Consumer<List<String>> consumerMail = Mail::notifyMessage;
		Function<List<String>, List<String>> funcMail = Mail::sendMessage;
		Function<List<String>, List<String>> funcMail2 = Mail::sendMessage2;
		// CompletableFuture<Void> future = CompletableFuture.supplyAsync(supplierMail).thenApplyAsync(funcMail).thenAcceptAsync(consumerMail);
		// future.get();
		CompletableFuture<List<String>> cfSupply = CompletableFuture.supplyAsync(supplierMail);
		CompletableFuture<List<String>> cfApply1 = cfSupply.thenApplyAsync(funcMail);
		CompletableFuture<List<String>> cfApply2 = cfSupply.thenApplyAsync(funcMail2);
		cfApply1.thenCombineAsync(cfApply2, (x, y) -> new ArrayList<String>() {
			{
				addAll(x);
				addAll(y);
			}
		}).thenAccept(consumerMail).get();
		
	}

}
