package com.ys.sbbs.utility;

import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.OutputStream;
import java.time.LocalDateTime;

import javax.imageio.ImageIO;

public class AsideUtil {

	public String getTodayQuote(String filename) {
		String result = null;
		try {
			BufferedReader br = new BufferedReader(new FileReader(filename), 1024);
			int index = (int) Math.floor(Math.random() * 100);
			for (int i=0; i<=index; i++)
				result = br.readLine();
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public String squareImage(String profilePath, String fname) {
		String newFname = null;
		try {
			File file = new File(profilePath + fname);
			BufferedImage buffer = ImageIO.read(file);
			int width = buffer.getWidth();
			int height = buffer.getHeight();
			int size = width, x = 0, y = 0;
			if (width > height) {
				size = height;
				x = (width - size) / 2;
			} else if (width < height) {
				size = width;
				y = (height - size) / 2;
			}
			
			String now = LocalDateTime.now().toString().substring(0,22).replaceAll("[-T:.]", "");
			int idx = fname.lastIndexOf('.');
			String format = fname.substring(idx+1);
			newFname = now + fname.substring(idx);
			
			BufferedImage dest = new BufferedImage(size, size, BufferedImage.TYPE_INT_RGB);
			Graphics2D g = dest.createGraphics();
			g.setComposite(AlphaComposite.Src);
			g.drawImage(buffer, 0, 0, size, size, x, y, x + size, y + size, null);
			g.dispose();
			
			File dstFile = new File(profilePath + newFname);
			OutputStream os = new FileOutputStream(dstFile);
			ImageIO.write(dest, format, os);
			os.close();
			file.delete();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return newFname;
	}
	
}
