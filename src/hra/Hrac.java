package hra;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Hrac { 
	public static final int SIRKA = 40; 
	public static final int VYSKA = 33;
	
	private static final int KOEFICIENT_ZRYCHLENIA = 1; //velkost skoku hraca
	
	private static final int KOEFICIENT_RYCHLOSTI = 2; //rychlost padu hraca
	private BufferedImage img = null;
	
	private int x; //zaciatocna x-ova pozicia hraca, nemeni sa (hrac neskace dopredu)
	
	private int y; //zaciatocna y-ova pozicia hraca, meni sa (hrac skace hore a dole)
	private int rychlost;
	public Hrac(BufferedImage img){
		this.img = img;
		x = HraciaPlocha.SIRKA/2 - (img.getWidth()/2); //postaviù pan·Ëika na stred - zisùovanie stredu
		y = HraciaPlocha.VYSKA/2;
		
		rychlost = KOEFICIENT_RYCHLOSTI;
	}
	/**
	 * vola sa po naraze do steny, do kraju okna
	 */
	public void reset(){
		y = HraciaPlocha.VYSKA / 2;
		rychlost = KOEFICIENT_RYCHLOSTI;
		
	}
	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}
	public void skok(){
		rychlost = -17;
	}
	/**
	 * zaistuje pohyb hraca
	 */
	public void posun(){
		rychlost = rychlost + KOEFICIENT_ZRYCHLENIA;
		y = y + rychlost;
		
		
	}
	/**
	 * volana, ked chceme vykreslit daneho hraca
	 */
	public void paint(Graphics g){
		g.drawImage(img, x, y, null);	
	}
	
	public int getVyskaHraca(){ //vyska hraca dolezita kvoli narazom 
		return img.getHeight();
	}
	/**
	 * Vracia pomyselny stvorec/obdlznik, ktory opisuje toho hraca
	 * @return
	 */
	public Rectangle getMez(){
		return new Rectangle(x, y, img.getWidth(), img.getHeight());
	}
}
