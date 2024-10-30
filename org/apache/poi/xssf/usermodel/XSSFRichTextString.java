/*     */ package org.apache.poi.xssf.usermodel;
/*     */ 
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import java.util.SortedMap;
/*     */ import java.util.TreeMap;
/*     */ import java.util.regex.Matcher;
/*     */ import java.util.regex.Pattern;
/*     */ import javax.xml.namespace.b;
/*     */ import org.apache.poi.ss.usermodel.Font;
/*     */ import org.apache.poi.ss.usermodel.RichTextString;
/*     */ import org.apache.poi.util.Internal;
/*     */ import org.apache.poi.xssf.model.StylesTable;
/*     */ import org.apache.poi.xssf.model.ThemesTable;
/*     */ import org.apache.xmlbeans.XmlCursor;
/*     */ import org.apache.xmlbeans.XmlObject;
/*     */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTColor;
/*     */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFont;
/*     */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRElt;
/*     */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt;
/*     */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRst;
/*     */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.STXstring;
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
/*     */ public class XSSFRichTextString
/*     */   implements RichTextString
/*     */ {
/*  78 */   private static final Pattern utfPtrn = Pattern.compile("_x([0-9A-F]{4})_");
/*     */ 
/*     */   
/*     */   private CTRst st;
/*     */   
/*     */   private StylesTable styles;
/*     */ 
/*     */   
/*     */   public XSSFRichTextString(String paramString) {
/*  87 */     this.st = CTRst.Factory.newInstance();
/*  88 */     this.st.setT(paramString);
/*  89 */     preserveSpaces(this.st.xgetT());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XSSFRichTextString() {
/*  96 */     this.st = CTRst.Factory.newInstance();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XSSFRichTextString(CTRst paramCTRst) {
/* 103 */     this.st = paramCTRst;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void applyFont(int paramInt1, int paramInt2, short paramShort) {
/*     */     XSSFFont xSSFFont;
/* 115 */     if (this.styles == null) {
/*     */ 
/*     */       
/* 118 */       xSSFFont = new XSSFFont();
/* 119 */       xSSFFont.setFontName("#" + paramShort);
/*     */     } else {
/* 121 */       xSSFFont = this.styles.getFontAt(paramShort);
/*     */     } 
/* 123 */     applyFont(paramInt1, paramInt2, xSSFFont);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void applyFont(int paramInt1, int paramInt2, Font paramFont) {
/* 134 */     if (paramInt1 > paramInt2)
/* 135 */       throw new IllegalArgumentException("Start index must be less than end index, but had " + paramInt1 + " and " + paramInt2); 
/* 136 */     if (paramInt1 < 0 || paramInt2 > length()) {
/* 137 */       throw new IllegalArgumentException("Start and end index not in range, but had " + paramInt1 + " and " + paramInt2);
/*     */     }
/* 139 */     if (paramInt1 == paramInt2) {
/*     */       return;
/*     */     }
/* 142 */     if (this.st.sizeOfRArray() == 0 && this.st.isSetT()) {
/*     */       
/* 144 */       this.st.addNewR().setT(this.st.getT());
/* 145 */       this.st.unsetT();
/*     */     } 
/*     */     
/* 148 */     String str = getString();
/* 149 */     XSSFFont xSSFFont = (XSSFFont)paramFont;
/*     */     
/* 151 */     TreeMap<Integer, CTRPrElt> treeMap = getFormatMap(this.st);
/* 152 */     CTRPrElt cTRPrElt = CTRPrElt.Factory.newInstance();
/* 153 */     setRunAttributes(xSSFFont.getCTFont(), cTRPrElt);
/* 154 */     applyFont(treeMap, paramInt1, paramInt2, cTRPrElt);
/*     */     
/* 156 */     CTRst cTRst = buildCTRst(str, treeMap);
/* 157 */     this.st.set((XmlObject)cTRst);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void applyFont(Font paramFont) {
/* 165 */     String str = getString();
/* 166 */     applyFont(0, str.length(), paramFont);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void applyFont(short paramShort) {
/*     */     XSSFFont xSSFFont;
/* 176 */     if (this.styles == null) {
/* 177 */       xSSFFont = new XSSFFont();
/* 178 */       xSSFFont.setFontName("#" + paramShort);
/*     */     } else {
/* 180 */       xSSFFont = this.styles.getFontAt(paramShort);
/*     */     } 
/* 182 */     String str = getString();
/* 183 */     applyFont(0, str.length(), xSSFFont);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void append(String paramString, XSSFFont paramXSSFFont) {
/* 193 */     if (this.st.sizeOfRArray() == 0 && this.st.isSetT()) {
/*     */       
/* 195 */       CTRElt cTRElt1 = this.st.addNewR();
/* 196 */       cTRElt1.setT(this.st.getT());
/* 197 */       preserveSpaces(cTRElt1.xgetT());
/* 198 */       this.st.unsetT();
/*     */     } 
/* 200 */     CTRElt cTRElt = this.st.addNewR();
/* 201 */     cTRElt.setT(paramString);
/* 202 */     preserveSpaces(cTRElt.xgetT());
/*     */     
/* 204 */     if (paramXSSFFont != null) {
/* 205 */       CTRPrElt cTRPrElt = cTRElt.addNewRPr();
/* 206 */       setRunAttributes(paramXSSFFont.getCTFont(), cTRPrElt);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void append(String paramString) {
/* 216 */     append(paramString, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void setRunAttributes(CTFont paramCTFont, CTRPrElt paramCTRPrElt) {
/* 223 */     if (paramCTFont.sizeOfBArray() > 0) paramCTRPrElt.addNewB().setVal(paramCTFont.getBArray(0).getVal()); 
/* 224 */     if (paramCTFont.sizeOfUArray() > 0) paramCTRPrElt.addNewU().setVal(paramCTFont.getUArray(0).getVal()); 
/* 225 */     if (paramCTFont.sizeOfIArray() > 0) paramCTRPrElt.addNewI().setVal(paramCTFont.getIArray(0).getVal()); 
/* 226 */     if (paramCTFont.sizeOfColorArray() > 0) {
/* 227 */       CTColor cTColor1 = paramCTFont.getColorArray(0);
/* 228 */       CTColor cTColor2 = paramCTRPrElt.addNewColor();
/* 229 */       if (cTColor1.isSetAuto()) cTColor2.setAuto(cTColor1.getAuto()); 
/* 230 */       if (cTColor1.isSetIndexed()) cTColor2.setIndexed(cTColor1.getIndexed()); 
/* 231 */       if (cTColor1.isSetRgb()) cTColor2.setRgb(cTColor1.getRgb()); 
/* 232 */       if (cTColor1.isSetTheme()) cTColor2.setTheme(cTColor1.getTheme()); 
/* 233 */       if (cTColor1.isSetTint()) cTColor2.setTint(cTColor1.getTint()); 
/*     */     } 
/* 235 */     if (paramCTFont.sizeOfSzArray() > 0) paramCTRPrElt.addNewSz().setVal(paramCTFont.getSzArray(0).getVal()); 
/* 236 */     if (paramCTFont.sizeOfNameArray() > 0) paramCTRPrElt.addNewRFont().setVal(paramCTFont.getNameArray(0).getVal()); 
/* 237 */     if (paramCTFont.sizeOfFamilyArray() > 0) paramCTRPrElt.addNewFamily().setVal(paramCTFont.getFamilyArray(0).getVal()); 
/* 238 */     if (paramCTFont.sizeOfSchemeArray() > 0) paramCTRPrElt.addNewScheme().setVal(paramCTFont.getSchemeArray(0).getVal()); 
/* 239 */     if (paramCTFont.sizeOfCharsetArray() > 0) paramCTRPrElt.addNewCharset().setVal(paramCTFont.getCharsetArray(0).getVal()); 
/* 240 */     if (paramCTFont.sizeOfCondenseArray() > 0) paramCTRPrElt.addNewCondense().setVal(paramCTFont.getCondenseArray(0).getVal()); 
/* 241 */     if (paramCTFont.sizeOfExtendArray() > 0) paramCTRPrElt.addNewExtend().setVal(paramCTFont.getExtendArray(0).getVal()); 
/* 242 */     if (paramCTFont.sizeOfVertAlignArray() > 0) paramCTRPrElt.addNewVertAlign().setVal(paramCTFont.getVertAlignArray(0).getVal()); 
/* 243 */     if (paramCTFont.sizeOfOutlineArray() > 0) paramCTRPrElt.addNewOutline().setVal(paramCTFont.getOutlineArray(0).getVal()); 
/* 244 */     if (paramCTFont.sizeOfShadowArray() > 0) paramCTRPrElt.addNewShadow().setVal(paramCTFont.getShadowArray(0).getVal()); 
/* 245 */     if (paramCTFont.sizeOfStrikeArray() > 0) paramCTRPrElt.addNewStrike().setVal(paramCTFont.getStrikeArray(0).getVal());
/*     */   
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean hasFormatting() {
/* 253 */     CTRElt[] arrayOfCTRElt = this.st.getRArray();
/* 254 */     if (arrayOfCTRElt == null || arrayOfCTRElt.length == 0) {
/* 255 */       return false;
/*     */     }
/* 257 */     for (CTRElt cTRElt : arrayOfCTRElt) {
/* 258 */       if (cTRElt.isSetRPr()) return true; 
/*     */     } 
/* 260 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void clearFormatting() {
/* 267 */     String str = getString();
/* 268 */     this.st.setRArray(null);
/* 269 */     this.st.setT(str);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getIndexOfFormattingRun(int paramInt) {
/* 279 */     if (this.st.sizeOfRArray() == 0) return 0;
/*     */     
/* 281 */     int i = 0;
/* 282 */     for (byte b = 0; b < this.st.sizeOfRArray(); b++) {
/* 283 */       CTRElt cTRElt = this.st.getRArray(b);
/* 284 */       if (b == paramInt) return i;
/*     */       
/* 286 */       i += cTRElt.getT().length();
/*     */     } 
/* 288 */     return -1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getLengthOfFormattingRun(int paramInt) {
/* 298 */     if (this.st.sizeOfRArray() == 0 || paramInt >= this.st.sizeOfRArray()) {
/* 299 */       return -1;
/*     */     }
/*     */     
/* 302 */     CTRElt cTRElt = this.st.getRArray(paramInt);
/* 303 */     return cTRElt.getT().length();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getString() {
/* 310 */     if (this.st.sizeOfRArray() == 0) {
/* 311 */       return utfDecode(this.st.getT());
/*     */     }
/* 313 */     StringBuilder stringBuilder = new StringBuilder();
/* 314 */     for (CTRElt cTRElt : this.st.getRArray()) {
/* 315 */       stringBuilder.append(cTRElt.getT());
/*     */     }
/* 317 */     return utfDecode(stringBuilder.toString());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setString(String paramString) {
/* 326 */     clearFormatting();
/* 327 */     this.st.setT(paramString);
/* 328 */     preserveSpaces(this.st.xgetT());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 335 */     return getString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int length() {
/* 342 */     return getString().length();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int numFormattingRuns() {
/* 349 */     return this.st.sizeOfRArray();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XSSFFont getFontOfFormattingRun(int paramInt) {
/* 359 */     if (this.st.sizeOfRArray() == 0 || paramInt >= this.st.sizeOfRArray()) {
/* 360 */       return null;
/*     */     }
/*     */     
/* 363 */     CTRElt cTRElt = this.st.getRArray(paramInt);
/* 364 */     if (cTRElt.getRPr() != null) {
/* 365 */       XSSFFont xSSFFont = new XSSFFont(toCTFont(cTRElt.getRPr()));
/* 366 */       xSSFFont.setThemesTable(getThemesTable());
/* 367 */       return xSSFFont;
/*     */     } 
/*     */     
/* 370 */     return null;
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
/*     */   public XSSFFont getFontAtIndex(int paramInt) {
/* 382 */     ThemesTable themesTable = getThemesTable();
/* 383 */     int i = 0;
/* 384 */     for (CTRElt cTRElt : this.st.getRArray()) {
/* 385 */       int j = cTRElt.getT().length();
/* 386 */       if (paramInt >= i && paramInt < i + j) {
/* 387 */         XSSFFont xSSFFont = new XSSFFont(toCTFont(cTRElt.getRPr()));
/* 388 */         xSSFFont.setThemesTable(themesTable);
/* 389 */         return xSSFFont;
/*     */       } 
/*     */       
/* 392 */       i += j;
/*     */     } 
/* 394 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Internal
/*     */   public CTRst getCTRst() {
/* 403 */     return this.st;
/*     */   }
/*     */   
/*     */   protected void setStylesTableReference(StylesTable paramStylesTable) {
/* 407 */     this.styles = paramStylesTable;
/* 408 */     if (this.st.sizeOfRArray() > 0) {
/* 409 */       for (CTRElt cTRElt : this.st.getRArray()) {
/* 410 */         CTRPrElt cTRPrElt = cTRElt.getRPr();
/* 411 */         if (cTRPrElt != null && cTRPrElt.sizeOfRFontArray() > 0) {
/* 412 */           String str = cTRPrElt.getRFontArray(0).getVal();
/* 413 */           if (str.startsWith("#")) {
/* 414 */             int i = Integer.parseInt(str.substring(1));
/* 415 */             XSSFFont xSSFFont = this.styles.getFontAt(i);
/* 416 */             cTRPrElt.removeRFont(0);
/* 417 */             setRunAttributes(xSSFFont.getCTFont(), cTRPrElt);
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected static CTFont toCTFont(CTRPrElt paramCTRPrElt) {
/* 429 */     CTFont cTFont = CTFont.Factory.newInstance();
/*     */ 
/*     */     
/* 432 */     if (paramCTRPrElt == null) {
/* 433 */       return cTFont;
/*     */     }
/*     */     
/* 436 */     if (paramCTRPrElt.sizeOfBArray() > 0) cTFont.addNewB().setVal(paramCTRPrElt.getBArray(0).getVal()); 
/* 437 */     if (paramCTRPrElt.sizeOfUArray() > 0) cTFont.addNewU().setVal(paramCTRPrElt.getUArray(0).getVal()); 
/* 438 */     if (paramCTRPrElt.sizeOfIArray() > 0) cTFont.addNewI().setVal(paramCTRPrElt.getIArray(0).getVal()); 
/* 439 */     if (paramCTRPrElt.sizeOfColorArray() > 0) {
/* 440 */       CTColor cTColor1 = paramCTRPrElt.getColorArray(0);
/* 441 */       CTColor cTColor2 = cTFont.addNewColor();
/* 442 */       if (cTColor1.isSetAuto()) cTColor2.setAuto(cTColor1.getAuto()); 
/* 443 */       if (cTColor1.isSetIndexed()) cTColor2.setIndexed(cTColor1.getIndexed()); 
/* 444 */       if (cTColor1.isSetRgb()) cTColor2.setRgb(cTColor1.getRgb()); 
/* 445 */       if (cTColor1.isSetTheme()) cTColor2.setTheme(cTColor1.getTheme()); 
/* 446 */       if (cTColor1.isSetTint()) cTColor2.setTint(cTColor1.getTint()); 
/*     */     } 
/* 448 */     if (paramCTRPrElt.sizeOfSzArray() > 0) cTFont.addNewSz().setVal(paramCTRPrElt.getSzArray(0).getVal()); 
/* 449 */     if (paramCTRPrElt.sizeOfRFontArray() > 0) cTFont.addNewName().setVal(paramCTRPrElt.getRFontArray(0).getVal()); 
/* 450 */     if (paramCTRPrElt.sizeOfFamilyArray() > 0) cTFont.addNewFamily().setVal(paramCTRPrElt.getFamilyArray(0).getVal()); 
/* 451 */     if (paramCTRPrElt.sizeOfSchemeArray() > 0) cTFont.addNewScheme().setVal(paramCTRPrElt.getSchemeArray(0).getVal()); 
/* 452 */     if (paramCTRPrElt.sizeOfCharsetArray() > 0) cTFont.addNewCharset().setVal(paramCTRPrElt.getCharsetArray(0).getVal()); 
/* 453 */     if (paramCTRPrElt.sizeOfCondenseArray() > 0) cTFont.addNewCondense().setVal(paramCTRPrElt.getCondenseArray(0).getVal()); 
/* 454 */     if (paramCTRPrElt.sizeOfExtendArray() > 0) cTFont.addNewExtend().setVal(paramCTRPrElt.getExtendArray(0).getVal()); 
/* 455 */     if (paramCTRPrElt.sizeOfVertAlignArray() > 0) cTFont.addNewVertAlign().setVal(paramCTRPrElt.getVertAlignArray(0).getVal()); 
/* 456 */     if (paramCTRPrElt.sizeOfOutlineArray() > 0) cTFont.addNewOutline().setVal(paramCTRPrElt.getOutlineArray(0).getVal()); 
/* 457 */     if (paramCTRPrElt.sizeOfShadowArray() > 0) cTFont.addNewShadow().setVal(paramCTRPrElt.getShadowArray(0).getVal()); 
/* 458 */     if (paramCTRPrElt.sizeOfStrikeArray() > 0) cTFont.addNewStrike().setVal(paramCTRPrElt.getStrikeArray(0).getVal());
/*     */     
/* 460 */     return cTFont;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected static void preserveSpaces(STXstring paramSTXstring) {
/* 469 */     String str = paramSTXstring.getStringValue();
/* 470 */     if (str != null && str.length() > 0) {
/* 471 */       char c1 = str.charAt(0);
/* 472 */       char c2 = str.charAt(str.length() - 1);
/* 473 */       if (Character.isWhitespace(c1) || Character.isWhitespace(c2)) {
/* 474 */         XmlCursor xmlCursor = paramSTXstring.newCursor();
/* 475 */         xmlCursor.toNextToken();
/* 476 */         xmlCursor.insertAttributeWithValue(new b("http://www.w3.org/XML/1998/namespace", "space"), "preserve");
/* 477 */         xmlCursor.dispose();
/*     */       } 
/*     */     } 
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
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static String utfDecode(String paramString) {
/* 496 */     if (paramString == null || !paramString.contains("_x")) {
/* 497 */       return paramString;
/*     */     }
/*     */     
/* 500 */     StringBuilder stringBuilder = new StringBuilder();
/* 501 */     Matcher matcher = utfPtrn.matcher(paramString);
/* 502 */     int i = 0;
/* 503 */     while (matcher.find()) {
/* 504 */       int j = matcher.start();
/* 505 */       if (j > i) {
/* 506 */         stringBuilder.append(paramString.substring(i, j));
/*     */       }
/*     */       
/* 509 */       String str = matcher.group(1);
/* 510 */       int k = Integer.decode("0x" + str).intValue();
/* 511 */       stringBuilder.append((char)k);
/*     */       
/* 513 */       i = matcher.end();
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 518 */     if (i == 0) {
/* 519 */       return paramString;
/*     */     }
/*     */     
/* 522 */     stringBuilder.append(paramString.substring(i));
/* 523 */     return stringBuilder.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   void applyFont(TreeMap<Integer, CTRPrElt> paramTreeMap, int paramInt1, int paramInt2, CTRPrElt paramCTRPrElt) {
/* 529 */     int i = 0; Iterator<Integer> iterator;
/* 530 */     for (iterator = paramTreeMap.keySet().iterator(); iterator.hasNext(); ) {
/* 531 */       int j = ((Integer)iterator.next()).intValue();
/* 532 */       if (i >= paramInt1 && j < paramInt2) {
/* 533 */         iterator.remove();
/*     */       }
/* 535 */       i = j;
/*     */     } 
/*     */     
/* 538 */     if (paramInt1 > 0 && !paramTreeMap.containsKey(Integer.valueOf(paramInt1)))
/*     */     {
/* 540 */       for (Map.Entry<Integer, CTRPrElt> entry : paramTreeMap.entrySet()) {
/* 541 */         if (((Integer)entry.getKey()).intValue() > paramInt1) {
/* 542 */           paramTreeMap.put(Integer.valueOf(paramInt1), (CTRPrElt)entry.getValue());
/*     */           break;
/*     */         } 
/*     */       } 
/*     */     }
/* 547 */     paramTreeMap.put(Integer.valueOf(paramInt2), paramCTRPrElt);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 552 */     SortedMap<Integer, CTRPrElt> sortedMap = paramTreeMap.subMap(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
/* 553 */     for (; sortedMap.size() > 1; sortedMap.remove(sortedMap.lastKey()));
/*     */   }
/*     */   
/*     */   TreeMap<Integer, CTRPrElt> getFormatMap(CTRst paramCTRst) {
/* 557 */     int i = 0;
/* 558 */     TreeMap<Object, Object> treeMap = new TreeMap<Object, Object>();
/* 559 */     for (CTRElt cTRElt : paramCTRst.getRArray()) {
/* 560 */       String str = cTRElt.getT();
/* 561 */       CTRPrElt cTRPrElt = cTRElt.getRPr();
/*     */       
/* 563 */       i += str.length();
/* 564 */       treeMap.put(Integer.valueOf(i), cTRPrElt);
/*     */     } 
/* 566 */     return (TreeMap)treeMap;
/*     */   }
/*     */   
/*     */   CTRst buildCTRst(String paramString, TreeMap<Integer, CTRPrElt> paramTreeMap) {
/* 570 */     if (paramString.length() != ((Integer)paramTreeMap.lastKey()).intValue()) {
/* 571 */       throw new IllegalArgumentException("Text length was " + paramString.length() + " but the last format index was " + paramTreeMap.lastKey());
/*     */     }
/*     */     
/* 574 */     CTRst cTRst = CTRst.Factory.newInstance();
/* 575 */     int i = 0;
/* 576 */     for (Map.Entry<Integer, CTRPrElt> entry : paramTreeMap.entrySet()) {
/* 577 */       int j = ((Integer)entry.getKey()).intValue();
/* 578 */       CTRElt cTRElt = cTRst.addNewR();
/* 579 */       String str = paramString.substring(i, j);
/* 580 */       cTRElt.setT(str);
/* 581 */       preserveSpaces(cTRElt.xgetT());
/*     */       
/* 583 */       CTRPrElt cTRPrElt = (CTRPrElt)entry.getValue();
/* 584 */       if (cTRPrElt != null) {
/* 585 */         cTRElt.setRPr(cTRPrElt);
/*     */       }
/* 587 */       i = j;
/*     */     } 
/* 589 */     return cTRst;
/*     */   }
/*     */   
/*     */   private ThemesTable getThemesTable() {
/* 593 */     if (this.styles == null) return null; 
/* 594 */     return this.styles.getTheme();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xss\\usermodel\XSSFRichTextString.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */