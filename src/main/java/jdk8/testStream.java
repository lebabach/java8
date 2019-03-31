package jdk8;

import java.util.*;
import java.util.Map.Entry;
import java.util.function.ToIntFunction;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.apache.commons.lang3.StringUtils;


public class testStream implements Comparator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Developer> team = new ArrayList<>();
		Developer polyglot = new Developer("esoteric");
		polyglot.add("clojure");
		polyglot.add("scala");
		polyglot.add("groovy");
		polyglot.add("go");

		List<Subjects> subs = new ArrayList<Subjects>();
		subs.add(new Subjects("c#", 3, "2"));
		subs.add(new Subjects("java", 4, "2"));
		subs.add(new Subjects("cobol", 5, "2"));
		polyglot.setSubjects(subs);
		polyglot.setId(1);

		Developer busy = new Developer("esoteric");
		busy.add("java");
		busy.add("javascript");

		subs = new ArrayList<Subjects>();
		subs.add(new Subjects("c#", 6, "1"));
		subs.add(new Subjects("java", 7, "1"));
		subs.add(new Subjects("ruby", 9, "2"));
		busy.setSubjects(subs);
		busy.setId(1);

		Developer bach = new Developer("bach");
		bach.add("cobol");
		bach.add("c#");

		subs = new ArrayList<Subjects>();
		subs.add(new Subjects("Grovy", 8, "2"));
		subs.add(new Subjects("java", 10, "2"));
		subs.add(new Subjects("ruby", 11, "2"));
		bach.setSubjects(subs);
		bach.setId(3);

		team.add(polyglot);
		team.add(busy);
		team.add(bach);

		List<String> table1 = Arrays.asList("1", "2", "3", "4");
		List<String> table2 = Arrays.asList("1", "2", "5", "6", "4");

		System.out.println("1.getLanguage1");
		getLanguage1(team);
		System.out.println("\n2.getLanguage2");
		getLanguage2(team);
		System.out.println("\n3.countLanguage");
		countLanguage(team);
		System.out.println("\n4.countDeveloper");
		countDeveloper(team);
		System.out.println("\n5.countLanguageByDeveloper");
		countLanguageByDeveloper(team);
		System.out.println("\n6.FindLanguageWith");
		FindLanguageWith(team, "a");
		System.out.println("\n7.FindLanguageEachOfDeveloperWith");
		FindLanguageEachOfDeveloperWith(team, "a");
		System.out.println("\n8.getLanguagesBySkipAndTake");
		getLanguagesBySkipAndTakeAndDescSort(team);
		System.out.println("\n9.geListSubsWithSortAscNameAndDescMark");
		geListSubsWithSortAscNameAndDescMark(team);
		System.out.println("\n9.1 sortSubsOfDeveloper");
		sortSubsOfDeveloper(team);
		System.out.println("\n10.getLeftJoin ");
		System.out.println(getLeftJoin(table1, table2));
		System.out.println("\n11.groupMultikey1 ");
		groupMultikey1(team);
		System.out.println("\n11.stream advance ");
		streamAdvance(team);
		System.out.println("\n11.map duplicate ");
		mapDuplicate(team);
		System.out.println("\n11.partitionBy ");
		partitionBy(team);
		
		
		String test = "bach" ;
		System.out.println("check: "+test.equals(null));
	}

	public static void getLanguage1(List<Developer> team) {
		List<String> teamLanguages = team.stream().flatMap(l -> l.getLanguages().stream()).collect(Collectors.toList());
		teamLanguages.forEach(t -> {
			System.out.println("language (option1): " + t.toString());

		});

	}

	public static void getLanguage2(List<Developer> team) {
		Map<String, List<Developer>> groupByName = team.stream().collect(Collectors.groupingBy(d -> d.getName()));
		groupByName.entrySet().forEach(g -> {
			g.getValue().forEach(d -> {
				d.getLanguages().forEach(l -> {
					System.out.println("language (option2): " + l.toString());
				});

			});
		});
	}

	public static void countLanguage(List<Developer> team) {
		long numberOfLanguages = team.stream().map(l -> l.getLanguages()).flatMap(l -> l.stream()).count();
		System.out.println("Number of Language: " + numberOfLanguages);

	}

	public static void countDeveloper(List<Developer> team) {
		long numberOfLanguages = team.stream().map(l -> l.getName()).count();
		System.out.println("Number of Developer: " + numberOfLanguages);

	}

	public static void countLanguageByDeveloper(List<Developer> team) {
		List<GroupDeveloper> gE = team.stream().collect(Collectors.groupingBy(g -> g.getName())).entrySet().stream()
				.map(e -> {
					GroupDeveloper g = new GroupDeveloper();
					g.setName(e.getKey().toUpperCase());
					g.setNumberOfLanguage(e.getValue().stream().flatMap(m -> m.getLanguages().stream())
							.collect(Collectors.toList()).size());
					return g;
				}).collect(Collectors.toList());
		gE.forEach(g -> {
			System.out.println(g.getName() + " has number of langueage is : " + g.getNumberOfLanguage());
		});
	}

	public static void FindLanguageWith(List<Developer> team, String words) {
		List<String> languages = team.stream().flatMap(language -> language.getLanguages().stream())
				.filter(language -> language.contains(words)).collect(Collectors.toList());
		System.out.println("languages contain " + words);
		languages.forEach(g -> {

			System.out.println(g.toString());
		});
	}

	public static void FindLanguageEachOfDeveloperWith(List<Developer> team, String words) {
		List<Developer> developers = team.stream().collect(Collectors.groupingBy(g -> g.getName())).entrySet().stream()
				.map(e -> {
					List<String> languages = e.getValue().stream().flatMap(m -> m.getLanguages().stream())
							.filter(l -> l.contains(words)).collect(Collectors.toList());
					Developer d = new Developer(e.getKey());
					if (languages != null) {
						d.setLanguages(languages);
					} else {
						d.setLanguages(null);
					}
					return d;

				}).collect(Collectors.toList());
		developers.forEach(g -> {
			System.out.println(g.getName() + " has langueage is : " + g.getLanguages());
		});
	}

	public static void getLanguagesBySkipAndTakeAndDescSort(List<Developer> team) {
		List<Integer> i = team.stream().map(x -> x.getId()).collect(Collectors.toList());
		List<String> languages = team.stream().flatMap(x -> x.getLanguages().stream()).collect(Collectors.toList());
		languages = languages.stream().skip(3).limit(3).sorted(Comparator.reverseOrder()).collect(Collectors.toList());
		languages.forEach(l -> {
			System.out.println(l.toString());
		});
	}

	public static void geListSubsWithSortAscNameAndDescMark(List<Developer> team) {

		List<Subjects> subs = team.stream().flatMap(x -> x.getSubjects().stream())
				.sorted(Comparator.comparing(Subjects::getName).reversed().thenComparing(Subjects::getMark))
				.collect(Collectors.toList());
		subs.forEach(l -> {
			System.out.println(l.getName() + " has " + l.getMark());
		});
		
	}
	
	public static void sortSubsOfDeveloper(List<Developer> team){
		List<Developer>  devs= team.stream().map(item->{
			List<Subjects> subjects = item.subjects.stream().sorted(Comparator.comparing(Subjects::getName).reversed().thenComparing(Subjects::getMark)).collect(Collectors.toList());
			item.setSubjects(subjects);
			return item;
		}).collect(Collectors.toList());
		System.out.println("\n");
		devs.forEach(dev->System.out.println(dev.getName()+" ;Name of objects: "+dev.getSubjects().stream().map(item->item.getName()).collect(Collectors.joining(","))));
	}

	public static List<String> getLeftJoin(List<String> table1, List<String> table2) {
		return table1.stream().filter(x -> !table2.contains(x)).collect(Collectors.toList());
	}

	public static void groupMultikey1(List<Developer> team) {
		// distinct: And==>&&; Or ==> union new list;
		// override equals and hashcode. if hashcode are same, jump to equals
		Map<GroupNameId, List<Developer>> o = team.stream()
				.collect(Collectors.groupingBy(p -> new GroupNameId(p.getName(), p.getId()), Collectors.toList()));
		o.entrySet().forEach(x -> {
			System.out.println(x.getKey().keyId);

		});
		team.stream().collect(Collectors.groupingBy(p -> new HashMap<String, Integer>(), Collectors.toList()));

	}

	public static void groupParrallelGroup(List<Developer> team) {
		team.parallelStream().collect(Collectors.groupingByConcurrent(Developer::getName));
	}

	public static void streamAdvance(List<Developer> team) {
		String find = team.stream().flatMap(x -> x.getLanguages().stream()).filter(x -> x.equals("bach")).findFirst()
				.orElseGet(() -> StringUtils.EMPTY);
		System.out.println("\n find?: " + find);
		System.out.println("summaryStatistics id : "
				+ team.stream().mapToInt(d -> IntStream.of(d.getId()).sum()).summaryStatistics());
		System.out.println("flatMapToIntIntSummaryStatistics id: "
				+ team.stream().flatMapToInt(d -> IntStream.of(d.getId())).summaryStatistics());

		IntSummaryStatistics intSummaryStatistics = team.stream().flatMap(x -> x.getSubjects().stream())
				.mapToInt(x -> IntStream.of(x.getMark()).sum()).summaryStatistics();
		System.out.println("summaryStatistics mark of subjects: " + intSummaryStatistics);

		team.stream().flatMap(x -> x.getSubjects().stream()).mapToInt(x -> IntStream.of(x.getMark()).sum())
				.summaryStatistics();
		List<IntSummaryStatistics> liIntSummaryStatistics = team.stream()
				.map(d -> d.getSubjects().stream().mapToInt(s -> IntStream.of(s.getMark()).sum()).summaryStatistics())
				.collect(Collectors.toList());
		System.out.println("List SummaryStatistics mark of subjects: " + liIntSummaryStatistics);

	}

	public static void mapDuplicate(List<Developer> team) {
		Map<String, Integer> mapNameMark = team.stream().flatMap(x -> x.getSubjects().stream())
				.collect(Collectors.toMap(Subjects::getName, Subjects::getMark, (x, y) -> {
					//choose key
					//System.out.println("x: " + x + " y " + y);
					return x;
				}));
		System.out.println(mapNameMark);
		//mapNameMark.entrySet().forEach(x -> System.out.println("key: " + x.getKey() + " value: " + x.getValue()));
	}
	
	public static void partitionBy(List<Developer> team){
		Map<Boolean,List<Developer>> partitionName =  team.stream().collect(Collectors.partitioningBy(x->x.getName().equals("esoteric")));
		System.out.println(partitionName);
		System.out.println(team.stream().collect(Collectors.groupingBy(x->x.getName(), Collectors.counting())).entrySet().stream().map(x->x.getKey()).collect(Collectors.toList()));
		System.out.println(team.stream().collect(Collectors.groupingBy(x->x.getName(), Collectors.maxBy(Comparator.comparing(b->b.getSubjects().size()))))
				//.entrySet().stream().map(x->x.getValue()).filter(Optional::isPresent).map(Optional::get).map(x->x.getId()).collect(Collectors.toList()));
				.entrySet().stream().map(x->x.getValue()).filter(Optional::isPresent).map(Optional::get).map(x->x.getId()).collect(Collectors.toList()));
		//Collectors.mapping(mapper, downstream)
	}

	@Override
	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	

}
