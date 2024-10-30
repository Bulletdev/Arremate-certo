/*     */ package org.apache.poi.hssf.usermodel;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Properties;
/*     */ import java.util.StringTokenizer;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class FontDetails
/*     */ {
/*     */   private String _fontName;
/*     */   private int _height;
/*  32 */   private final Map<Character, Integer> charWidths = new HashMap<Character, Integer>();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public FontDetails(String paramString, int paramInt) {
/*  42 */     this._fontName = paramString;
/*  43 */     this._height = paramInt;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getFontName() {
/*  48 */     return this._fontName;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getHeight() {
/*  53 */     return this._height;
/*     */   }
/*     */ 
/*     */   
/*     */   public void addChar(char paramChar, int paramInt) {
/*  58 */     this.charWidths.put(Character.valueOf(paramChar), Integer.valueOf(paramInt));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getCharWidth(char paramChar) {
/*  68 */     Integer integer = this.charWidths.get(Character.valueOf(paramChar));
/*  69 */     if (integer == null) {
/*  70 */       return ('W' == paramChar) ? 0 : getCharWidth('W');
/*     */     }
/*  72 */     return integer.intValue();
/*     */   }
/*     */ 
/*     */   
/*     */   public void addChars(char[] paramArrayOfchar, int[] paramArrayOfint) {
/*  77 */     for (byte b = 0; b < paramArrayOfchar.length; b++)
/*     */     {
/*  79 */       this.charWidths.put(Character.valueOf(paramArrayOfchar[b]), Integer.valueOf(paramArrayOfint[b]));
/*     */     }
/*     */   }
/*     */   
/*     */   protected static String buildFontHeightProperty(String paramString) {
/*  84 */     return "font." + paramString + ".height";
/*     */   }
/*     */   protected static String buildFontWidthsProperty(String paramString) {
/*  87 */     return "font." + paramString + ".widths";
/*     */   }
/*     */   protected static String buildFontCharactersProperty(String paramString) {
/*  90 */     return "font." + paramString + ".characters";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static FontDetails create(String paramString, Properties paramProperties) {
/* 103 */     String str1 = paramProperties.getProperty(buildFontHeightProperty(paramString));
/* 104 */     String str2 = paramProperties.getProperty(buildFontWidthsProperty(paramString));
/* 105 */     String str3 = paramProperties.getProperty(buildFontCharactersProperty(paramString));
/*     */ 
/*     */     
/* 108 */     if (str1 == null || str2 == null || str3 == null)
/*     */     {
/*     */       
/* 111 */       throw new IllegalArgumentException("The supplied FontMetrics doesn't know about the font '" + paramString + "', so we can't use it. Please add it to your font metrics file (see StaticFontMetrics.getFontDetails");
/*     */     }
/*     */     
/* 114 */     int i = Integer.parseInt(str1);
/* 115 */     FontDetails fontDetails = new FontDetails(paramString, i);
/* 116 */     String[] arrayOfString1 = split(str3, ",", -1);
/* 117 */     String[] arrayOfString2 = split(str2, ",", -1);
/* 118 */     if (arrayOfString1.length != arrayOfString2.length)
/* 119 */       throw new RuntimeException("Number of characters does not number of widths for font " + paramString); 
/* 120 */     for (byte b = 0; b < arrayOfString2.length; b++) {
/*     */       
/* 122 */       if (arrayOfString1[b].length() != 0)
/* 123 */         fontDetails.addChar(arrayOfString1[b].charAt(0), Integer.parseInt(arrayOfString2[b])); 
/*     */     } 
/* 125 */     return fontDetails;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getStringWidth(String paramString) {
/* 136 */     int i = 0;
/* 137 */     for (byte b = 0; b < paramString.length(); b++)
/*     */     {
/* 139 */       i += getCharWidth(paramString.charAt(b));
/*     */     }
/* 141 */     return i;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static String[] split(String paramString1, String paramString2, int paramInt) {
/* 150 */     StringTokenizer stringTokenizer = new StringTokenizer(paramString1, paramString2);
/* 151 */     int i = stringTokenizer.countTokens();
/* 152 */     if (paramInt != -1 && i > paramInt)
/* 153 */       i = paramInt; 
/* 154 */     String[] arrayOfString = new String[i];
/* 155 */     for (byte b = 0; stringTokenizer.hasMoreTokens(); b++) {
/*     */       
/* 157 */       if (paramInt != -1 && b == i - 1) {
/*     */         
/* 159 */         StringBuffer stringBuffer = new StringBuffer(paramString1.length() * (i - b) / i);
/* 160 */         while (stringTokenizer.hasMoreTokens()) {
/*     */           
/* 162 */           stringBuffer.append(stringTokenizer.nextToken());
/* 163 */           if (stringTokenizer.hasMoreTokens())
/* 164 */             stringBuffer.append(paramString2); 
/*     */         } 
/* 166 */         arrayOfString[b] = stringBuffer.toString().trim();
/*     */         break;
/*     */       } 
/* 169 */       arrayOfString[b] = stringTokenizer.nextToken().trim();
/*     */     } 
/*     */     
/* 172 */     return arrayOfString;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hss\\usermodel\FontDetails.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */