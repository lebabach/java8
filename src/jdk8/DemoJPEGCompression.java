package jdk8;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Transparency;
import java.awt.color.ColorSpace;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.ComponentColorModel;
import java.awt.image.DataBuffer;
import java.awt.image.DataBufferByte;
import java.awt.image.DataBufferUShort;
import java.awt.image.IndexColorModel;
import java.awt.image.Raster;
import java.awt.image.RenderedImage;
import java.awt.image.WritableRaster;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.stream.FileImageOutputStream;
import javax.imageio.stream.ImageOutputStream;
import javax.swing.JFrame;

public class DemoJPEGCompression {
	/*
	 * Application starting point, open an image and save it in JPEG with a
	 * compression factor.
	 */
	public static void main(String[] args) throws IOException {
		// Load the image (it is hard-coded here to make the code simpler).
		String imageFile = "E:\\images\\bach8.jpg";
		BufferedImage i = ImageIO.read(new File(imageFile));

		// Show results with different compression ratio.
		compressAndShow(resize(i, i.getWidth(), i.getHeight(), 40), 0.5f);

	}

	public static void compressAndShow(BufferedImage image, float quality) throws IOException {
		// Get a ImageWriter for jpeg format.
		Iterator<ImageWriter> writers = ImageIO.getImageWritersBySuffix("jpeg");
		if (!writers.hasNext())
			throw new IllegalStateException("No writers found");
		ImageWriter writer = (ImageWriter) writers.next();
		// Create the ImageWriteParam to compress the image.
		ImageWriteParam param = writer.getDefaultWriteParam();
		param.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
		param.setCompressionQuality(quality);
		// The output will be a ByteArrayOutputStream (in memory)
		ByteArrayOutputStream bos = new ByteArrayOutputStream(32768);
		ImageOutputStream ios = ImageIO.createImageOutputStream(bos);
		writer.setOutput(ios);
		writer.write(null, new IIOImage(image, null, null), param);
		ios.flush(); // otherwise the buffer size will be zero!
		// From the ByteArrayOutputStream create a RenderedImage.
		ByteArrayInputStream in = new ByteArrayInputStream(bos.toByteArray());
		RenderedImage out = ImageIO.read(in);
		int size = bos.toByteArray().length;

		// Uncomment code below to save the compressed files.
		File file = new File("D:\\bachle111_5.jpg");
		FileImageOutputStream output = new FileImageOutputStream(file);
		writer.setOutput(output);
		writer.write(null, new IIOImage(image, null, null), param);
	}

	public static BufferedImage resize(BufferedImage img, int Width, int Height, int reduce) throws IOException {
		int newWidth = 1000;
		int newHeight = 1000;
		 double percentHeightWidth=0;
		 if(Width>Height){
		 percentHeightWidth=(double)Width/Height;
		 newHeight=(int)(newWidth/percentHeightWidth);
		 }else if(Width<Height){
		 percentHeightWidth=Height/Width;
		 newWidth=(int)(newHeight/percentHeightWidth);
		 }
		@SuppressWarnings("static-access")
		Image tmp = img.getScaledInstance(newWidth, newHeight, img.TYPE_INT_RGB);

		BufferedImage dimg = new BufferedImage(newWidth, newHeight, img.getType());

		Graphics2D g2d = dimg.createGraphics();
		g2d.setColor(Color.white);
		g2d.fillRect(0,0,dimg.getWidth(),dimg.getHeight());
		g2d.drawImage(tmp, 1,1, null);
		g2d.dispose();

		return dimg;
	}

}
