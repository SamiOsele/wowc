package Yep;

import java.awt.image.BufferedImage;

public class Character {

   private String name,klasse;
   private int maxHp, shield, ad, cdr;
   private String[] abilities;
   private BufferedImage img;


   public Character(String name, String klasse, int maxHp, int shield, int ad, int cdr, String[] abilities, BufferedImage img) {
      this.name = name;
      this.klasse = klasse;
      this.maxHp = maxHp;
      this.shield = shield;
      this.ad = ad;
      this.cdr = cdr;
      this.abilities = abilities;
      this.img = img;
   }

   public BufferedImage getImg() {
      return img;
   }



   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getKlasse() {
      return klasse;
   }

   public void setKlasse(String klasse) {
      this.klasse = klasse;
   }

   public int getMaxHp() {
      return maxHp;
   }

   public void setMaxHp(int maxHp) {
      this.maxHp = maxHp;
   }

   public int getShield() {
      return shield;
   }

   public void setShield(int shield) {
      this.shield = shield;
   }

   public int getAd() {
      return ad;
   }

   public void setAd(int ad) {
      this.ad = ad;
   }

   public int getCdr() {
      return cdr;
   }

   public void setCdr(int cdr) {
      this.cdr = cdr;
   }

   public String[] getAbilities() {
      return abilities;
   }

   public void setAbilities(String[] abilities) {
      this.abilities = abilities;
   }

}
