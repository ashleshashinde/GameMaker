package com.gamemaker.model;

import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;

import javax.imageio.ImageIO;

import org.apache.log4j.Logger;

public class ImageSprite extends Component implements Serializable {

	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(ImageSprite.class);
	private File imageName;

	public ImageSprite(File imageName, int initialPositionX, int initialPositionY, int spriteWidth, int spriteHeight) {
		this.imageName = imageName;
		super.positionX = initialPositionX;
		super.positionY = initialPositionY;
		this.height = spriteHeight;
		this.width = spriteWidth;
		super.status = "active";
	}

	@Override
	public void draw(Graphics2D g2d) {
		super.shape = new Rectangle2D.Double(positionX, positionY, width, height);
		BufferedImage img = null;
		//String filePath = System.getProperty("user.dir") + File.separator + "GameData" + File.separator + "images" + File.separator + imageName;
		try {
			img = ImageIO.read(imageName);
		} catch (IOException e) {
			logger.debug(e.getMessage());
		}
		g2d.drawImage(img, (int)positionX, (int)positionY,  (int)width, (int)height, null);
	}

	public File getImageName() {
		return imageName;
	}

	public void setImageName(File imageName) {
		this.imageName = imageName;
	}

}
