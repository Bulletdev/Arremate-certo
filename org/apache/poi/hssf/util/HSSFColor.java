/*      */ package org.apache.poi.hssf.util;
/*      */ 
/*      */ import java.lang.reflect.Field;
/*      */ import java.util.Collections;
/*      */ import java.util.HashMap;
/*      */ import java.util.Map;
/*      */ import org.apache.poi.ss.usermodel.Color;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class HSSFColor
/*      */   implements Color
/*      */ {
/*      */   private static Map<Integer, HSSFColor> indexHash;
/*      */   
/*      */   public static final Map<Integer, HSSFColor> getIndexHash() {
/*   53 */     if (indexHash == null) {
/*   54 */       indexHash = Collections.unmodifiableMap(createColorsByIndexMap());
/*      */     }
/*      */     
/*   57 */     return indexHash;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static final Map<Integer, HSSFColor> getMutableIndexHash() {
/*   66 */     return createColorsByIndexMap();
/*      */   }
/*      */   
/*      */   private static Map<Integer, HSSFColor> createColorsByIndexMap() {
/*   70 */     HSSFColor[] arrayOfHSSFColor = getAllColors();
/*   71 */     HashMap<Object, Object> hashMap = new HashMap<Object, Object>(arrayOfHSSFColor.length * 3 / 2);
/*      */     byte b;
/*   73 */     for (b = 0; b < arrayOfHSSFColor.length; b++) {
/*   74 */       HSSFColor hSSFColor = arrayOfHSSFColor[b];
/*      */       
/*   76 */       Integer integer = Integer.valueOf(hSSFColor.getIndex());
/*   77 */       if (hashMap.containsKey(integer)) {
/*   78 */         HSSFColor hSSFColor1 = (HSSFColor)hashMap.get(integer);
/*   79 */         throw new RuntimeException("Dup color index (" + integer + ") for colors (" + hSSFColor1.getClass().getName() + "),(" + hSSFColor.getClass().getName() + ")");
/*      */       } 
/*      */ 
/*      */       
/*   83 */       hashMap.put(integer, hSSFColor);
/*      */     } 
/*      */     
/*   86 */     for (b = 0; b < arrayOfHSSFColor.length; b++) {
/*   87 */       HSSFColor hSSFColor = arrayOfHSSFColor[b];
/*   88 */       Integer integer = getIndex2(hSSFColor);
/*   89 */       if (integer != null)
/*      */       {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*  101 */         hashMap.put(integer, hSSFColor); } 
/*      */     } 
/*  103 */     return (Map)hashMap;
/*      */   }
/*      */   
/*      */   private static Integer getIndex2(HSSFColor paramHSSFColor) {
/*      */     Field field;
/*      */     Short short_;
/*      */     try {
/*  110 */       field = paramHSSFColor.getClass().getDeclaredField("index2");
/*  111 */     } catch (NoSuchFieldException noSuchFieldException) {
/*      */       
/*  113 */       return null;
/*      */     } 
/*      */ 
/*      */     
/*      */     try {
/*  118 */       short_ = (Short)field.get(paramHSSFColor);
/*  119 */     } catch (IllegalArgumentException illegalArgumentException) {
/*  120 */       throw new RuntimeException(illegalArgumentException);
/*  121 */     } catch (IllegalAccessException illegalAccessException) {
/*  122 */       throw new RuntimeException(illegalAccessException);
/*      */     } 
/*  124 */     return Integer.valueOf(short_.intValue());
/*      */   }
/*      */ 
/*      */   
/*      */   private static HSSFColor[] getAllColors() {
/*  129 */     return new HSSFColor[] { new BLACK(), new BROWN(), new OLIVE_GREEN(), new DARK_GREEN(), new DARK_TEAL(), new DARK_BLUE(), new INDIGO(), new GREY_80_PERCENT(), new ORANGE(), new DARK_YELLOW(), new GREEN(), new TEAL(), new BLUE(), new BLUE_GREY(), new GREY_50_PERCENT(), new RED(), new LIGHT_ORANGE(), new LIME(), new SEA_GREEN(), new AQUA(), new LIGHT_BLUE(), new VIOLET(), new GREY_40_PERCENT(), new PINK(), new GOLD(), new YELLOW(), new BRIGHT_GREEN(), new TURQUOISE(), new DARK_RED(), new SKY_BLUE(), new PLUM(), new GREY_25_PERCENT(), new ROSE(), new LIGHT_YELLOW(), new LIGHT_GREEN(), new LIGHT_TURQUOISE(), new PALE_BLUE(), new LAVENDER(), new WHITE(), new CORNFLOWER_BLUE(), new LEMON_CHIFFON(), new MAROON(), new ORCHID(), new CORAL(), new ROYAL_BLUE(), new LIGHT_CORNFLOWER_BLUE(), new TAN() };
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static final Map<String, HSSFColor> getTripletHash() {
/*  155 */     return createColorsByHexStringMap();
/*      */   }
/*      */   
/*      */   private static Map<String, HSSFColor> createColorsByHexStringMap() {
/*  159 */     HSSFColor[] arrayOfHSSFColor = getAllColors();
/*  160 */     HashMap<Object, Object> hashMap = new HashMap<Object, Object>(arrayOfHSSFColor.length * 3 / 2);
/*      */     
/*  162 */     for (byte b = 0; b < arrayOfHSSFColor.length; b++) {
/*  163 */       HSSFColor hSSFColor = arrayOfHSSFColor[b];
/*      */       
/*  165 */       String str = hSSFColor.getHexString();
/*  166 */       if (hashMap.containsKey(str)) {
/*  167 */         HSSFColor hSSFColor1 = (HSSFColor)hashMap.get(str);
/*  168 */         throw new RuntimeException("Dup color hexString (" + str + ") for color (" + hSSFColor.getClass().getName() + ") - " + " already taken by (" + hSSFColor1.getClass().getName() + ")");
/*      */       } 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  174 */       hashMap.put(str, hSSFColor);
/*      */     } 
/*  176 */     return (Map)hashMap;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public short getIndex() {
/*  187 */     return 8;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public short[] getTriplet() {
/*  198 */     return BLACK.triplet;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getHexString() {
/*  209 */     return "0:0:0";
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static HSSFColor toHSSFColor(Color paramColor) {
/*  223 */     if (paramColor != null && !(paramColor instanceof HSSFColor)) {
/*  224 */       throw new IllegalArgumentException("Only HSSFColor objects are supported");
/*      */     }
/*  226 */     return (HSSFColor)paramColor;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static final class BLACK
/*      */     extends HSSFColor
/*      */   {
/*      */     public static final short index = 8;
/*      */ 
/*      */     
/*  238 */     public static final short[] triplet = new short[] { 0, 0, 0 };
/*      */ 
/*      */     
/*      */     public static final String hexString = "0:0:0";
/*      */ 
/*      */ 
/*      */     
/*      */     public short getIndex() {
/*  246 */       return 8;
/*      */     }
/*      */ 
/*      */     
/*      */     public short[] getTriplet() {
/*  251 */       return triplet;
/*      */     }
/*      */ 
/*      */     
/*      */     public String getHexString() {
/*  256 */       return "0:0:0";
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static final class BROWN
/*      */     extends HSSFColor
/*      */   {
/*      */     public static final short index = 60;
/*      */ 
/*      */     
/*  269 */     public static final short[] triplet = new short[] { 153, 51, 0 };
/*      */ 
/*      */     
/*      */     public static final String hexString = "9999:3333:0";
/*      */ 
/*      */ 
/*      */     
/*      */     public short getIndex() {
/*  277 */       return 60;
/*      */     }
/*      */ 
/*      */     
/*      */     public short[] getTriplet() {
/*  282 */       return triplet;
/*      */     }
/*      */ 
/*      */     
/*      */     public String getHexString() {
/*  287 */       return "9999:3333:0";
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static class OLIVE_GREEN
/*      */     extends HSSFColor
/*      */   {
/*      */     public static final short index = 59;
/*      */ 
/*      */     
/*  300 */     public static final short[] triplet = new short[] { 51, 51, 0 };
/*      */ 
/*      */     
/*      */     public static final String hexString = "3333:3333:0";
/*      */ 
/*      */ 
/*      */     
/*      */     public short getIndex() {
/*  308 */       return 59;
/*      */     }
/*      */ 
/*      */     
/*      */     public short[] getTriplet() {
/*  313 */       return triplet;
/*      */     }
/*      */ 
/*      */     
/*      */     public String getHexString() {
/*  318 */       return "3333:3333:0";
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static final class DARK_GREEN
/*      */     extends HSSFColor
/*      */   {
/*      */     public static final short index = 58;
/*      */ 
/*      */     
/*  331 */     public static final short[] triplet = new short[] { 0, 51, 0 };
/*      */ 
/*      */     
/*      */     public static final String hexString = "0:3333:0";
/*      */ 
/*      */ 
/*      */     
/*      */     public short getIndex() {
/*  339 */       return 58;
/*      */     }
/*      */ 
/*      */     
/*      */     public short[] getTriplet() {
/*  344 */       return triplet;
/*      */     }
/*      */ 
/*      */     
/*      */     public String getHexString() {
/*  349 */       return "0:3333:0";
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static final class DARK_TEAL
/*      */     extends HSSFColor
/*      */   {
/*      */     public static final short index = 56;
/*      */ 
/*      */     
/*  362 */     public static final short[] triplet = new short[] { 0, 51, 102 };
/*      */ 
/*      */     
/*      */     public static final String hexString = "0:3333:6666";
/*      */ 
/*      */ 
/*      */     
/*      */     public short getIndex() {
/*  370 */       return 56;
/*      */     }
/*      */ 
/*      */     
/*      */     public short[] getTriplet() {
/*  375 */       return triplet;
/*      */     }
/*      */ 
/*      */     
/*      */     public String getHexString() {
/*  380 */       return "0:3333:6666";
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static final class DARK_BLUE
/*      */     extends HSSFColor
/*      */   {
/*      */     public static final short index = 18;
/*      */ 
/*      */     
/*      */     public static final short index2 = 32;
/*      */     
/*  394 */     public static final short[] triplet = new short[] { 0, 0, 128 };
/*      */ 
/*      */     
/*      */     public static final String hexString = "0:0:8080";
/*      */ 
/*      */ 
/*      */     
/*      */     public short getIndex() {
/*  402 */       return 18;
/*      */     }
/*      */ 
/*      */     
/*      */     public short[] getTriplet() {
/*  407 */       return triplet;
/*      */     }
/*      */ 
/*      */     
/*      */     public String getHexString() {
/*  412 */       return "0:0:8080";
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static final class INDIGO
/*      */     extends HSSFColor
/*      */   {
/*      */     public static final short index = 62;
/*      */ 
/*      */     
/*  425 */     public static final short[] triplet = new short[] { 51, 51, 153 };
/*      */ 
/*      */     
/*      */     public static final String hexString = "3333:3333:9999";
/*      */ 
/*      */ 
/*      */     
/*      */     public short getIndex() {
/*  433 */       return 62;
/*      */     }
/*      */ 
/*      */     
/*      */     public short[] getTriplet() {
/*  438 */       return triplet;
/*      */     }
/*      */ 
/*      */     
/*      */     public String getHexString() {
/*  443 */       return "3333:3333:9999";
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static final class GREY_80_PERCENT
/*      */     extends HSSFColor
/*      */   {
/*      */     public static final short index = 63;
/*      */ 
/*      */     
/*  456 */     public static final short[] triplet = new short[] { 51, 51, 51 };
/*      */ 
/*      */     
/*      */     public static final String hexString = "3333:3333:3333";
/*      */ 
/*      */ 
/*      */     
/*      */     public short getIndex() {
/*  464 */       return 63;
/*      */     }
/*      */ 
/*      */     
/*      */     public short[] getTriplet() {
/*  469 */       return triplet;
/*      */     }
/*      */ 
/*      */     
/*      */     public String getHexString() {
/*  474 */       return "3333:3333:3333";
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static final class DARK_RED
/*      */     extends HSSFColor
/*      */   {
/*      */     public static final short index = 16;
/*      */ 
/*      */     
/*      */     public static final short index2 = 37;
/*      */     
/*  488 */     public static final short[] triplet = new short[] { 128, 0, 0 };
/*      */ 
/*      */     
/*      */     public static final String hexString = "8080:0:0";
/*      */ 
/*      */ 
/*      */     
/*      */     public short getIndex() {
/*  496 */       return 16;
/*      */     }
/*      */ 
/*      */     
/*      */     public short[] getTriplet() {
/*  501 */       return triplet;
/*      */     }
/*      */ 
/*      */     
/*      */     public String getHexString() {
/*  506 */       return "8080:0:0";
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static final class ORANGE
/*      */     extends HSSFColor
/*      */   {
/*      */     public static final short index = 53;
/*      */ 
/*      */     
/*  519 */     public static final short[] triplet = new short[] { 255, 102, 0 };
/*      */ 
/*      */     
/*      */     public static final String hexString = "FFFF:6666:0";
/*      */ 
/*      */ 
/*      */     
/*      */     public short getIndex() {
/*  527 */       return 53;
/*      */     }
/*      */ 
/*      */     
/*      */     public short[] getTriplet() {
/*  532 */       return triplet;
/*      */     }
/*      */ 
/*      */     
/*      */     public String getHexString() {
/*  537 */       return "FFFF:6666:0";
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static final class DARK_YELLOW
/*      */     extends HSSFColor
/*      */   {
/*      */     public static final short index = 19;
/*      */ 
/*      */     
/*  550 */     public static final short[] triplet = new short[] { 128, 128, 0 };
/*      */ 
/*      */     
/*      */     public static final String hexString = "8080:8080:0";
/*      */ 
/*      */ 
/*      */     
/*      */     public short getIndex() {
/*  558 */       return 19;
/*      */     }
/*      */ 
/*      */     
/*      */     public short[] getTriplet() {
/*  563 */       return triplet;
/*      */     }
/*      */ 
/*      */     
/*      */     public String getHexString() {
/*  568 */       return "8080:8080:0";
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static final class GREEN
/*      */     extends HSSFColor
/*      */   {
/*      */     public static final short index = 17;
/*      */ 
/*      */     
/*  581 */     public static final short[] triplet = new short[] { 0, 128, 0 };
/*      */ 
/*      */     
/*      */     public static final String hexString = "0:8080:0";
/*      */ 
/*      */ 
/*      */     
/*      */     public short getIndex() {
/*  589 */       return 17;
/*      */     }
/*      */ 
/*      */     
/*      */     public short[] getTriplet() {
/*  594 */       return triplet;
/*      */     }
/*      */ 
/*      */     
/*      */     public String getHexString() {
/*  599 */       return "0:8080:0";
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static final class TEAL
/*      */     extends HSSFColor
/*      */   {
/*      */     public static final short index = 21;
/*      */ 
/*      */     
/*      */     public static final short index2 = 38;
/*      */     
/*  613 */     public static final short[] triplet = new short[] { 0, 128, 128 };
/*      */ 
/*      */     
/*      */     public static final String hexString = "0:8080:8080";
/*      */ 
/*      */ 
/*      */     
/*      */     public short getIndex() {
/*  621 */       return 21;
/*      */     }
/*      */ 
/*      */     
/*      */     public short[] getTriplet() {
/*  626 */       return triplet;
/*      */     }
/*      */ 
/*      */     
/*      */     public String getHexString() {
/*  631 */       return "0:8080:8080";
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static final class BLUE
/*      */     extends HSSFColor
/*      */   {
/*      */     public static final short index = 12;
/*      */ 
/*      */     
/*      */     public static final short index2 = 39;
/*      */     
/*  645 */     public static final short[] triplet = new short[] { 0, 0, 255 };
/*      */ 
/*      */     
/*      */     public static final String hexString = "0:0:FFFF";
/*      */ 
/*      */ 
/*      */     
/*      */     public short getIndex() {
/*  653 */       return 12;
/*      */     }
/*      */ 
/*      */     
/*      */     public short[] getTriplet() {
/*  658 */       return triplet;
/*      */     }
/*      */ 
/*      */     
/*      */     public String getHexString() {
/*  663 */       return "0:0:FFFF";
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static final class BLUE_GREY
/*      */     extends HSSFColor
/*      */   {
/*      */     public static final short index = 54;
/*      */ 
/*      */     
/*  676 */     public static final short[] triplet = new short[] { 102, 102, 153 };
/*      */ 
/*      */     
/*      */     public static final String hexString = "6666:6666:9999";
/*      */ 
/*      */ 
/*      */     
/*      */     public short getIndex() {
/*  684 */       return 54;
/*      */     }
/*      */ 
/*      */     
/*      */     public short[] getTriplet() {
/*  689 */       return triplet;
/*      */     }
/*      */ 
/*      */     
/*      */     public String getHexString() {
/*  694 */       return "6666:6666:9999";
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static final class GREY_50_PERCENT
/*      */     extends HSSFColor
/*      */   {
/*      */     public static final short index = 23;
/*      */ 
/*      */     
/*  707 */     public static final short[] triplet = new short[] { 128, 128, 128 };
/*      */ 
/*      */     
/*      */     public static final String hexString = "8080:8080:8080";
/*      */ 
/*      */ 
/*      */     
/*      */     public short getIndex() {
/*  715 */       return 23;
/*      */     }
/*      */ 
/*      */     
/*      */     public short[] getTriplet() {
/*  720 */       return triplet;
/*      */     }
/*      */ 
/*      */     
/*      */     public String getHexString() {
/*  725 */       return "8080:8080:8080";
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static final class RED
/*      */     extends HSSFColor
/*      */   {
/*      */     public static final short index = 10;
/*      */ 
/*      */     
/*  738 */     public static final short[] triplet = new short[] { 255, 0, 0 };
/*      */ 
/*      */     
/*      */     public static final String hexString = "FFFF:0:0";
/*      */ 
/*      */ 
/*      */     
/*      */     public short getIndex() {
/*  746 */       return 10;
/*      */     }
/*      */ 
/*      */     
/*      */     public short[] getTriplet() {
/*  751 */       return triplet;
/*      */     }
/*      */ 
/*      */     
/*      */     public String getHexString() {
/*  756 */       return "FFFF:0:0";
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static final class LIGHT_ORANGE
/*      */     extends HSSFColor
/*      */   {
/*      */     public static final short index = 52;
/*      */ 
/*      */     
/*  769 */     public static final short[] triplet = new short[] { 255, 153, 0 };
/*      */ 
/*      */     
/*      */     public static final String hexString = "FFFF:9999:0";
/*      */ 
/*      */ 
/*      */     
/*      */     public short getIndex() {
/*  777 */       return 52;
/*      */     }
/*      */ 
/*      */     
/*      */     public short[] getTriplet() {
/*  782 */       return triplet;
/*      */     }
/*      */ 
/*      */     
/*      */     public String getHexString() {
/*  787 */       return "FFFF:9999:0";
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static final class LIME
/*      */     extends HSSFColor
/*      */   {
/*      */     public static final short index = 50;
/*      */ 
/*      */     
/*  800 */     public static final short[] triplet = new short[] { 153, 204, 0 };
/*      */ 
/*      */     
/*      */     public static final String hexString = "9999:CCCC:0";
/*      */ 
/*      */ 
/*      */     
/*      */     public short getIndex() {
/*  808 */       return 50;
/*      */     }
/*      */ 
/*      */     
/*      */     public short[] getTriplet() {
/*  813 */       return triplet;
/*      */     }
/*      */ 
/*      */     
/*      */     public String getHexString() {
/*  818 */       return "9999:CCCC:0";
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static final class SEA_GREEN
/*      */     extends HSSFColor
/*      */   {
/*      */     public static final short index = 57;
/*      */ 
/*      */     
/*  831 */     public static final short[] triplet = new short[] { 51, 153, 102 };
/*      */ 
/*      */     
/*      */     public static final String hexString = "3333:9999:6666";
/*      */ 
/*      */ 
/*      */     
/*      */     public short getIndex() {
/*  839 */       return 57;
/*      */     }
/*      */ 
/*      */     
/*      */     public short[] getTriplet() {
/*  844 */       return triplet;
/*      */     }
/*      */ 
/*      */     
/*      */     public String getHexString() {
/*  849 */       return "3333:9999:6666";
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static final class AQUA
/*      */     extends HSSFColor
/*      */   {
/*      */     public static final short index = 49;
/*      */ 
/*      */     
/*  862 */     public static final short[] triplet = new short[] { 51, 204, 204 };
/*      */ 
/*      */     
/*      */     public static final String hexString = "3333:CCCC:CCCC";
/*      */ 
/*      */ 
/*      */     
/*      */     public short getIndex() {
/*  870 */       return 49;
/*      */     }
/*      */ 
/*      */     
/*      */     public short[] getTriplet() {
/*  875 */       return triplet;
/*      */     }
/*      */ 
/*      */     
/*      */     public String getHexString() {
/*  880 */       return "3333:CCCC:CCCC";
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static final class LIGHT_BLUE
/*      */     extends HSSFColor
/*      */   {
/*      */     public static final short index = 48;
/*      */ 
/*      */     
/*  893 */     public static final short[] triplet = new short[] { 51, 102, 255 };
/*      */ 
/*      */     
/*      */     public static final String hexString = "3333:6666:FFFF";
/*      */ 
/*      */ 
/*      */     
/*      */     public short getIndex() {
/*  901 */       return 48;
/*      */     }
/*      */ 
/*      */     
/*      */     public short[] getTriplet() {
/*  906 */       return triplet;
/*      */     }
/*      */ 
/*      */     
/*      */     public String getHexString() {
/*  911 */       return "3333:6666:FFFF";
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static final class VIOLET
/*      */     extends HSSFColor
/*      */   {
/*      */     public static final short index = 20;
/*      */ 
/*      */     
/*      */     public static final short index2 = 36;
/*      */     
/*  925 */     public static final short[] triplet = new short[] { 128, 0, 128 };
/*      */ 
/*      */     
/*      */     public static final String hexString = "8080:0:8080";
/*      */ 
/*      */ 
/*      */     
/*      */     public short getIndex() {
/*  933 */       return 20;
/*      */     }
/*      */ 
/*      */     
/*      */     public short[] getTriplet() {
/*  938 */       return triplet;
/*      */     }
/*      */ 
/*      */     
/*      */     public String getHexString() {
/*  943 */       return "8080:0:8080";
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static final class GREY_40_PERCENT
/*      */     extends HSSFColor
/*      */   {
/*      */     public static final short index = 55;
/*      */ 
/*      */     
/*  956 */     public static final short[] triplet = new short[] { 150, 150, 150 };
/*      */ 
/*      */     
/*      */     public static final String hexString = "9696:9696:9696";
/*      */ 
/*      */ 
/*      */     
/*      */     public short getIndex() {
/*  964 */       return 55;
/*      */     }
/*      */ 
/*      */     
/*      */     public short[] getTriplet() {
/*  969 */       return triplet;
/*      */     }
/*      */ 
/*      */     
/*      */     public String getHexString() {
/*  974 */       return "9696:9696:9696";
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static final class PINK
/*      */     extends HSSFColor
/*      */   {
/*      */     public static final short index = 14;
/*      */ 
/*      */     
/*      */     public static final short index2 = 33;
/*      */     
/*  988 */     public static final short[] triplet = new short[] { 255, 0, 255 };
/*      */ 
/*      */     
/*      */     public static final String hexString = "FFFF:0:FFFF";
/*      */ 
/*      */ 
/*      */     
/*      */     public short getIndex() {
/*  996 */       return 14;
/*      */     }
/*      */ 
/*      */     
/*      */     public short[] getTriplet() {
/* 1001 */       return triplet;
/*      */     }
/*      */ 
/*      */     
/*      */     public String getHexString() {
/* 1006 */       return "FFFF:0:FFFF";
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static final class GOLD
/*      */     extends HSSFColor
/*      */   {
/*      */     public static final short index = 51;
/*      */ 
/*      */     
/* 1019 */     public static final short[] triplet = new short[] { 255, 204, 0 };
/*      */ 
/*      */     
/*      */     public static final String hexString = "FFFF:CCCC:0";
/*      */ 
/*      */ 
/*      */     
/*      */     public short getIndex() {
/* 1027 */       return 51;
/*      */     }
/*      */ 
/*      */     
/*      */     public short[] getTriplet() {
/* 1032 */       return triplet;
/*      */     }
/*      */ 
/*      */     
/*      */     public String getHexString() {
/* 1037 */       return "FFFF:CCCC:0";
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static final class YELLOW
/*      */     extends HSSFColor
/*      */   {
/*      */     public static final short index = 13;
/*      */ 
/*      */     
/*      */     public static final short index2 = 34;
/*      */     
/* 1051 */     public static final short[] triplet = new short[] { 255, 255, 0 };
/*      */ 
/*      */     
/*      */     public static final String hexString = "FFFF:FFFF:0";
/*      */ 
/*      */ 
/*      */     
/*      */     public short getIndex() {
/* 1059 */       return 13;
/*      */     }
/*      */ 
/*      */     
/*      */     public short[] getTriplet() {
/* 1064 */       return triplet;
/*      */     }
/*      */ 
/*      */     
/*      */     public String getHexString() {
/* 1069 */       return "FFFF:FFFF:0";
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static final class BRIGHT_GREEN
/*      */     extends HSSFColor
/*      */   {
/*      */     public static final short index = 11;
/*      */ 
/*      */     
/*      */     public static final short index2 = 35;
/*      */     
/* 1083 */     public static final short[] triplet = new short[] { 0, 255, 0 };
/*      */ 
/*      */     
/*      */     public static final String hexString = "0:FFFF:0";
/*      */ 
/*      */ 
/*      */     
/*      */     public short getIndex() {
/* 1091 */       return 11;
/*      */     }
/*      */ 
/*      */     
/*      */     public String getHexString() {
/* 1096 */       return "0:FFFF:0";
/*      */     }
/*      */ 
/*      */     
/*      */     public short[] getTriplet() {
/* 1101 */       return triplet;
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static final class TURQUOISE
/*      */     extends HSSFColor
/*      */   {
/*      */     public static final short index = 15;
/*      */ 
/*      */     
/*      */     public static final short index2 = 35;
/*      */     
/* 1115 */     public static final short[] triplet = new short[] { 0, 255, 255 };
/*      */ 
/*      */     
/*      */     public static final String hexString = "0:FFFF:FFFF";
/*      */ 
/*      */ 
/*      */     
/*      */     public short getIndex() {
/* 1123 */       return 15;
/*      */     }
/*      */ 
/*      */     
/*      */     public short[] getTriplet() {
/* 1128 */       return triplet;
/*      */     }
/*      */ 
/*      */     
/*      */     public String getHexString() {
/* 1133 */       return "0:FFFF:FFFF";
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static final class SKY_BLUE
/*      */     extends HSSFColor
/*      */   {
/*      */     public static final short index = 40;
/*      */ 
/*      */     
/* 1146 */     public static final short[] triplet = new short[] { 0, 204, 255 };
/*      */ 
/*      */     
/*      */     public static final String hexString = "0:CCCC:FFFF";
/*      */ 
/*      */ 
/*      */     
/*      */     public short getIndex() {
/* 1154 */       return 40;
/*      */     }
/*      */ 
/*      */     
/*      */     public short[] getTriplet() {
/* 1159 */       return triplet;
/*      */     }
/*      */ 
/*      */     
/*      */     public String getHexString() {
/* 1164 */       return "0:CCCC:FFFF";
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static final class PLUM
/*      */     extends HSSFColor
/*      */   {
/*      */     public static final short index = 61;
/*      */ 
/*      */     
/*      */     public static final short index2 = 25;
/*      */     
/* 1178 */     public static final short[] triplet = new short[] { 153, 51, 102 };
/*      */ 
/*      */     
/*      */     public static final String hexString = "9999:3333:6666";
/*      */ 
/*      */ 
/*      */     
/*      */     public short getIndex() {
/* 1186 */       return 61;
/*      */     }
/*      */ 
/*      */     
/*      */     public short[] getTriplet() {
/* 1191 */       return triplet;
/*      */     }
/*      */ 
/*      */     
/*      */     public String getHexString() {
/* 1196 */       return "9999:3333:6666";
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static final class GREY_25_PERCENT
/*      */     extends HSSFColor
/*      */   {
/*      */     public static final short index = 22;
/*      */ 
/*      */     
/* 1209 */     public static final short[] triplet = new short[] { 192, 192, 192 };
/*      */ 
/*      */     
/*      */     public static final String hexString = "C0C0:C0C0:C0C0";
/*      */ 
/*      */ 
/*      */     
/*      */     public short getIndex() {
/* 1217 */       return 22;
/*      */     }
/*      */ 
/*      */     
/*      */     public short[] getTriplet() {
/* 1222 */       return triplet;
/*      */     }
/*      */ 
/*      */     
/*      */     public String getHexString() {
/* 1227 */       return "C0C0:C0C0:C0C0";
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static final class ROSE
/*      */     extends HSSFColor
/*      */   {
/*      */     public static final short index = 45;
/*      */ 
/*      */     
/* 1240 */     public static final short[] triplet = new short[] { 255, 153, 204 };
/*      */ 
/*      */     
/*      */     public static final String hexString = "FFFF:9999:CCCC";
/*      */ 
/*      */ 
/*      */     
/*      */     public short getIndex() {
/* 1248 */       return 45;
/*      */     }
/*      */ 
/*      */     
/*      */     public short[] getTriplet() {
/* 1253 */       return triplet;
/*      */     }
/*      */ 
/*      */     
/*      */     public String getHexString() {
/* 1258 */       return "FFFF:9999:CCCC";
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static final class TAN
/*      */     extends HSSFColor
/*      */   {
/*      */     public static final short index = 47;
/*      */ 
/*      */     
/* 1271 */     public static final short[] triplet = new short[] { 255, 204, 153 };
/*      */ 
/*      */     
/*      */     public static final String hexString = "FFFF:CCCC:9999";
/*      */ 
/*      */ 
/*      */     
/*      */     public short getIndex() {
/* 1279 */       return 47;
/*      */     }
/*      */ 
/*      */     
/*      */     public short[] getTriplet() {
/* 1284 */       return triplet;
/*      */     }
/*      */ 
/*      */     
/*      */     public String getHexString() {
/* 1289 */       return "FFFF:CCCC:9999";
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static final class LIGHT_YELLOW
/*      */     extends HSSFColor
/*      */   {
/*      */     public static final short index = 43;
/*      */ 
/*      */     
/* 1302 */     public static final short[] triplet = new short[] { 255, 255, 153 };
/*      */ 
/*      */     
/*      */     public static final String hexString = "FFFF:FFFF:9999";
/*      */ 
/*      */ 
/*      */     
/*      */     public short getIndex() {
/* 1310 */       return 43;
/*      */     }
/*      */ 
/*      */     
/*      */     public short[] getTriplet() {
/* 1315 */       return triplet;
/*      */     }
/*      */ 
/*      */     
/*      */     public String getHexString() {
/* 1320 */       return "FFFF:FFFF:9999";
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static final class LIGHT_GREEN
/*      */     extends HSSFColor
/*      */   {
/*      */     public static final short index = 42;
/*      */ 
/*      */     
/* 1333 */     public static final short[] triplet = new short[] { 204, 255, 204 };
/*      */ 
/*      */     
/*      */     public static final String hexString = "CCCC:FFFF:CCCC";
/*      */ 
/*      */ 
/*      */     
/*      */     public short getIndex() {
/* 1341 */       return 42;
/*      */     }
/*      */ 
/*      */     
/*      */     public short[] getTriplet() {
/* 1346 */       return triplet;
/*      */     }
/*      */ 
/*      */     
/*      */     public String getHexString() {
/* 1351 */       return "CCCC:FFFF:CCCC";
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static final class LIGHT_TURQUOISE
/*      */     extends HSSFColor
/*      */   {
/*      */     public static final short index = 41;
/*      */ 
/*      */     
/*      */     public static final short index2 = 27;
/*      */     
/* 1365 */     public static final short[] triplet = new short[] { 204, 255, 255 };
/*      */ 
/*      */     
/*      */     public static final String hexString = "CCCC:FFFF:FFFF";
/*      */ 
/*      */ 
/*      */     
/*      */     public short getIndex() {
/* 1373 */       return 41;
/*      */     }
/*      */ 
/*      */     
/*      */     public short[] getTriplet() {
/* 1378 */       return triplet;
/*      */     }
/*      */ 
/*      */     
/*      */     public String getHexString() {
/* 1383 */       return "CCCC:FFFF:FFFF";
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static final class PALE_BLUE
/*      */     extends HSSFColor
/*      */   {
/*      */     public static final short index = 44;
/*      */ 
/*      */     
/* 1396 */     public static final short[] triplet = new short[] { 153, 204, 255 };
/*      */ 
/*      */     
/*      */     public static final String hexString = "9999:CCCC:FFFF";
/*      */ 
/*      */ 
/*      */     
/*      */     public short getIndex() {
/* 1404 */       return 44;
/*      */     }
/*      */ 
/*      */     
/*      */     public short[] getTriplet() {
/* 1409 */       return triplet;
/*      */     }
/*      */ 
/*      */     
/*      */     public String getHexString() {
/* 1414 */       return "9999:CCCC:FFFF";
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static final class LAVENDER
/*      */     extends HSSFColor
/*      */   {
/*      */     public static final short index = 46;
/*      */ 
/*      */     
/* 1427 */     public static final short[] triplet = new short[] { 204, 153, 255 };
/*      */ 
/*      */     
/*      */     public static final String hexString = "CCCC:9999:FFFF";
/*      */ 
/*      */ 
/*      */     
/*      */     public short getIndex() {
/* 1435 */       return 46;
/*      */     }
/*      */ 
/*      */     
/*      */     public short[] getTriplet() {
/* 1440 */       return triplet;
/*      */     }
/*      */ 
/*      */     
/*      */     public String getHexString() {
/* 1445 */       return "CCCC:9999:FFFF";
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static final class WHITE
/*      */     extends HSSFColor
/*      */   {
/*      */     public static final short index = 9;
/*      */ 
/*      */     
/* 1458 */     public static final short[] triplet = new short[] { 255, 255, 255 };
/*      */ 
/*      */     
/*      */     public static final String hexString = "FFFF:FFFF:FFFF";
/*      */ 
/*      */ 
/*      */     
/*      */     public short getIndex() {
/* 1466 */       return 9;
/*      */     }
/*      */ 
/*      */     
/*      */     public short[] getTriplet() {
/* 1471 */       return triplet;
/*      */     }
/*      */ 
/*      */     
/*      */     public String getHexString() {
/* 1476 */       return "FFFF:FFFF:FFFF";
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static final class CORNFLOWER_BLUE
/*      */     extends HSSFColor
/*      */   {
/*      */     public static final short index = 24;
/*      */     
/* 1487 */     public static final short[] triplet = new short[] { 153, 153, 255 };
/*      */ 
/*      */     
/*      */     public static final String hexString = "9999:9999:FFFF";
/*      */ 
/*      */ 
/*      */     
/*      */     public short getIndex() {
/* 1495 */       return 24;
/*      */     }
/*      */ 
/*      */     
/*      */     public short[] getTriplet() {
/* 1500 */       return triplet;
/*      */     }
/*      */ 
/*      */     
/*      */     public String getHexString() {
/* 1505 */       return "9999:9999:FFFF";
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static final class LEMON_CHIFFON
/*      */     extends HSSFColor
/*      */   {
/*      */     public static final short index = 26;
/*      */ 
/*      */     
/* 1517 */     public static final short[] triplet = new short[] { 255, 255, 204 };
/*      */ 
/*      */     
/*      */     public static final String hexString = "FFFF:FFFF:CCCC";
/*      */ 
/*      */ 
/*      */     
/*      */     public short getIndex() {
/* 1525 */       return 26;
/*      */     }
/*      */ 
/*      */     
/*      */     public short[] getTriplet() {
/* 1530 */       return triplet;
/*      */     }
/*      */ 
/*      */     
/*      */     public String getHexString() {
/* 1535 */       return "FFFF:FFFF:CCCC";
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static final class MAROON
/*      */     extends HSSFColor
/*      */   {
/*      */     public static final short index = 25;
/*      */     
/* 1546 */     public static final short[] triplet = new short[] { 127, 0, 0 };
/*      */ 
/*      */     
/*      */     public static final String hexString = "8000:0:0";
/*      */ 
/*      */ 
/*      */     
/*      */     public short getIndex() {
/* 1554 */       return 25;
/*      */     }
/*      */ 
/*      */     
/*      */     public short[] getTriplet() {
/* 1559 */       return triplet;
/*      */     }
/*      */ 
/*      */     
/*      */     public String getHexString() {
/* 1564 */       return "8000:0:0";
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static final class ORCHID
/*      */     extends HSSFColor
/*      */   {
/*      */     public static final short index = 28;
/*      */     
/* 1575 */     public static final short[] triplet = new short[] { 102, 0, 102 };
/*      */ 
/*      */     
/*      */     public static final String hexString = "6666:0:6666";
/*      */ 
/*      */ 
/*      */     
/*      */     public short getIndex() {
/* 1583 */       return 28;
/*      */     }
/*      */ 
/*      */     
/*      */     public short[] getTriplet() {
/* 1588 */       return triplet;
/*      */     }
/*      */ 
/*      */     
/*      */     public String getHexString() {
/* 1593 */       return "6666:0:6666";
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static final class CORAL
/*      */     extends HSSFColor
/*      */   {
/*      */     public static final short index = 29;
/*      */     
/* 1604 */     public static final short[] triplet = new short[] { 255, 128, 128 };
/*      */ 
/*      */     
/*      */     public static final String hexString = "FFFF:8080:8080";
/*      */ 
/*      */ 
/*      */     
/*      */     public short getIndex() {
/* 1612 */       return 29;
/*      */     }
/*      */ 
/*      */     
/*      */     public short[] getTriplet() {
/* 1617 */       return triplet;
/*      */     }
/*      */ 
/*      */     
/*      */     public String getHexString() {
/* 1622 */       return "FFFF:8080:8080";
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static final class ROYAL_BLUE
/*      */     extends HSSFColor
/*      */   {
/*      */     public static final short index = 30;
/*      */     
/* 1633 */     public static final short[] triplet = new short[] { 0, 102, 204 };
/*      */ 
/*      */     
/*      */     public static final String hexString = "0:6666:CCCC";
/*      */ 
/*      */ 
/*      */     
/*      */     public short getIndex() {
/* 1641 */       return 30;
/*      */     }
/*      */ 
/*      */     
/*      */     public short[] getTriplet() {
/* 1646 */       return triplet;
/*      */     }
/*      */ 
/*      */     
/*      */     public String getHexString() {
/* 1651 */       return "0:6666:CCCC";
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static final class LIGHT_CORNFLOWER_BLUE
/*      */     extends HSSFColor
/*      */   {
/*      */     public static final short index = 31;
/*      */     
/* 1662 */     public static final short[] triplet = new short[] { 204, 204, 255 };
/*      */ 
/*      */     
/*      */     public static final String hexString = "CCCC:CCCC:FFFF";
/*      */ 
/*      */ 
/*      */     
/*      */     public short getIndex() {
/* 1670 */       return 31;
/*      */     }
/*      */ 
/*      */     
/*      */     public short[] getTriplet() {
/* 1675 */       return triplet;
/*      */     }
/*      */ 
/*      */     
/*      */     public String getHexString() {
/* 1680 */       return "CCCC:CCCC:FFFF";
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static final class AUTOMATIC
/*      */     extends HSSFColor
/*      */   {
/* 1694 */     private static HSSFColor instance = new AUTOMATIC();
/*      */     
/*      */     public static final short index = 64;
/*      */ 
/*      */     
/*      */     public short getIndex() {
/* 1700 */       return 64;
/*      */     }
/*      */ 
/*      */     
/*      */     public short[] getTriplet() {
/* 1705 */       return HSSFColor.BLACK.triplet;
/*      */     }
/*      */ 
/*      */     
/*      */     public String getHexString() {
/* 1710 */       return "0:0:0";
/*      */     }
/*      */     
/*      */     public static HSSFColor getInstance() {
/* 1714 */       return instance;
/*      */     }
/*      */   }
/*      */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hss\\util\HSSFColor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */