/*     */ package org.apache.poi.hssf.usermodel;
/*     */ 
/*     */ import java.util.Iterator;
/*     */ import org.apache.poi.hssf.model.InternalWorkbook;
/*     */ import org.apache.poi.hssf.record.LabelSSTRecord;
/*     */ import org.apache.poi.hssf.record.common.UnicodeString;
/*     */ import org.apache.poi.ss.usermodel.Font;
/*     */ import org.apache.poi.ss.usermodel.RichTextString;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class HSSFRichTextString
/*     */   implements Comparable<HSSFRichTextString>, RichTextString
/*     */ {
/*     */   public static final short NO_FONT = 0;
/*     */   private UnicodeString _string;
/*     */   private InternalWorkbook _book;
/*     */   private LabelSSTRecord _record;
/*     */   
/*     */   public HSSFRichTextString() {
/*  79 */     this("");
/*     */   }
/*     */   
/*     */   public HSSFRichTextString(String paramString) {
/*  83 */     if (paramString == null) {
/*  84 */       this._string = new UnicodeString("");
/*     */     } else {
/*  86 */       this._string = new UnicodeString(paramString);
/*     */     } 
/*     */   }
/*     */   
/*     */   HSSFRichTextString(InternalWorkbook paramInternalWorkbook, LabelSSTRecord paramLabelSSTRecord) {
/*  91 */     setWorkbookReferences(paramInternalWorkbook, paramLabelSSTRecord);
/*     */     
/*  93 */     this._string = paramInternalWorkbook.getSSTString(paramLabelSSTRecord.getSSTIndex());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setWorkbookReferences(InternalWorkbook paramInternalWorkbook, LabelSSTRecord paramLabelSSTRecord) {
/* 100 */     this._book = paramInternalWorkbook;
/* 101 */     this._record = paramLabelSSTRecord;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private UnicodeString cloneStringIfRequired() {
/* 109 */     if (this._book == null)
/* 110 */       return this._string; 
/* 111 */     return (UnicodeString)this._string.clone();
/*     */   }
/*     */ 
/*     */   
/*     */   private void addToSSTIfRequired() {
/* 116 */     if (this._book != null) {
/* 117 */       int i = this._book.addSSTString(this._string);
/* 118 */       this._record.setSSTIndex(i);
/*     */ 
/*     */       
/* 121 */       this._string = this._book.getSSTString(i);
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
/*     */   public void applyFont(int paramInt1, int paramInt2, short paramShort) {
/* 135 */     if (paramInt1 > paramInt2)
/* 136 */       throw new IllegalArgumentException("Start index must be less than end index."); 
/* 137 */     if (paramInt1 < 0 || paramInt2 > length())
/* 138 */       throw new IllegalArgumentException("Start and end index not in range."); 
/* 139 */     if (paramInt1 == paramInt2) {
/*     */       return;
/*     */     }
/*     */ 
/*     */     
/* 144 */     short s = 0;
/* 145 */     if (paramInt2 != length()) {
/* 146 */       s = getFontAtIndex(paramInt2);
/*     */     }
/*     */ 
/*     */     
/* 150 */     this._string = cloneStringIfRequired();
/* 151 */     Iterator<UnicodeString.FormatRun> iterator = this._string.formatIterator();
/* 152 */     if (iterator != null) {
/* 153 */       while (iterator.hasNext()) {
/* 154 */         UnicodeString.FormatRun formatRun = iterator.next();
/* 155 */         if (formatRun.getCharacterPos() >= paramInt1 && formatRun.getCharacterPos() < paramInt2) {
/* 156 */           iterator.remove();
/*     */         }
/*     */       } 
/*     */     }
/*     */     
/* 161 */     this._string.addFormatRun(new UnicodeString.FormatRun((short)paramInt1, paramShort));
/* 162 */     if (paramInt2 != length()) {
/* 163 */       this._string.addFormatRun(new UnicodeString.FormatRun((short)paramInt2, s));
/*     */     }
/* 165 */     addToSSTIfRequired();
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
/*     */   public void applyFont(int paramInt1, int paramInt2, Font paramFont) {
/* 177 */     applyFont(paramInt1, paramInt2, ((HSSFFont)paramFont).getIndex());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void applyFont(Font paramFont) {
/* 186 */     applyFont(0, this._string.getCharCount(), paramFont);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void clearFormatting() {
/* 193 */     this._string = cloneStringIfRequired();
/* 194 */     this._string.clearFormatting();
/* 195 */     addToSSTIfRequired();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getString() {
/* 203 */     return this._string.getString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   UnicodeString getUnicodeString() {
/* 212 */     return cloneStringIfRequired();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   UnicodeString getRawUnicodeString() {
/* 223 */     return this._string;
/*     */   }
/*     */ 
/*     */   
/*     */   void setUnicodeString(UnicodeString paramUnicodeString) {
/* 228 */     this._string = paramUnicodeString;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int length() {
/* 236 */     return this._string.getCharCount();
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
/*     */   public short getFontAtIndex(int paramInt) {
/* 249 */     int i = this._string.getFormatRunCount();
/* 250 */     UnicodeString.FormatRun formatRun = null;
/* 251 */     for (byte b = 0; b < i; b++) {
/* 252 */       UnicodeString.FormatRun formatRun1 = this._string.getFormatRun(b);
/* 253 */       if (formatRun1.getCharacterPos() > paramInt) {
/*     */         break;
/*     */       }
/* 256 */       formatRun = formatRun1;
/*     */     } 
/* 258 */     if (formatRun == null) {
/* 259 */       return 0;
/*     */     }
/* 261 */     return formatRun.getFontIndex();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int numFormattingRuns() {
/* 272 */     return this._string.getFormatRunCount();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getIndexOfFormattingRun(int paramInt) {
/* 282 */     UnicodeString.FormatRun formatRun = this._string.getFormatRun(paramInt);
/* 283 */     return formatRun.getCharacterPos();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public short getFontOfFormattingRun(int paramInt) {
/* 294 */     UnicodeString.FormatRun formatRun = this._string.getFormatRun(paramInt);
/* 295 */     return formatRun.getFontIndex();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int compareTo(HSSFRichTextString paramHSSFRichTextString) {
/* 302 */     return this._string.compareTo(paramHSSFRichTextString._string);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 307 */     if (paramObject instanceof HSSFRichTextString) {
/* 308 */       return this._string.equals(((HSSFRichTextString)paramObject)._string);
/*     */     }
/* 310 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 316 */     assert false : "hashCode not designed";
/* 317 */     return 42;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 326 */     return this._string.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void applyFont(short paramShort) {
/* 336 */     applyFont(0, this._string.getCharCount(), paramShort);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hss\\usermodel\HSSFRichTextString.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */