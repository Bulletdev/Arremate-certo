/*     */ package org.apache.poi.hssf.record.common;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Collections;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import org.apache.poi.hssf.record.RecordInputStream;
/*     */ import org.apache.poi.hssf.record.cont.ContinuableRecordInput;
/*     */ import org.apache.poi.hssf.record.cont.ContinuableRecordOutput;
/*     */ import org.apache.poi.util.BitField;
/*     */ import org.apache.poi.util.BitFieldFactory;
/*     */ import org.apache.poi.util.LittleEndianInput;
/*     */ import org.apache.poi.util.LittleEndianOutput;
/*     */ import org.apache.poi.util.POILogFactory;
/*     */ import org.apache.poi.util.POILogger;
/*     */ import org.apache.poi.util.StringUtil;
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
/*     */ public class UnicodeString
/*     */   implements Comparable<UnicodeString>
/*     */ {
/*  47 */   private static POILogger _logger = POILogFactory.getLogger(UnicodeString.class);
/*     */   
/*     */   private short field_1_charCount;
/*     */   private byte field_2_optionflags;
/*     */   private String field_3_string;
/*     */   private List<FormatRun> field_4_format_runs;
/*     */   private ExtRst field_5_ext_rst;
/*  54 */   private static final BitField highByte = BitFieldFactory.getInstance(1);
/*     */   
/*  56 */   private static final BitField extBit = BitFieldFactory.getInstance(4);
/*  57 */   private static final BitField richText = BitFieldFactory.getInstance(8);
/*     */   
/*     */   public static class FormatRun implements Comparable<FormatRun> {
/*     */     final short _character;
/*     */     short _fontIndex;
/*     */     
/*     */     public FormatRun(short param1Short1, short param1Short2) {
/*  64 */       this._character = param1Short1;
/*  65 */       this._fontIndex = param1Short2;
/*     */     }
/*     */     
/*     */     public FormatRun(LittleEndianInput param1LittleEndianInput) {
/*  69 */       this(param1LittleEndianInput.readShort(), param1LittleEndianInput.readShort());
/*     */     }
/*     */     
/*     */     public short getCharacterPos() {
/*  73 */       return this._character;
/*     */     }
/*     */     
/*     */     public short getFontIndex() {
/*  77 */       return this._fontIndex;
/*     */     }
/*     */     
/*     */     public boolean equals(Object param1Object) {
/*  81 */       if (!(param1Object instanceof FormatRun)) {
/*  82 */         return false;
/*     */       }
/*  84 */       FormatRun formatRun = (FormatRun)param1Object;
/*     */       
/*  86 */       return (this._character == formatRun._character && this._fontIndex == formatRun._fontIndex);
/*     */     }
/*     */     
/*     */     public int compareTo(FormatRun param1FormatRun) {
/*  90 */       if (this._character == param1FormatRun._character && this._fontIndex == param1FormatRun._fontIndex) {
/*  91 */         return 0;
/*     */       }
/*  93 */       if (this._character == param1FormatRun._character) {
/*  94 */         return this._fontIndex - param1FormatRun._fontIndex;
/*     */       }
/*  96 */       return this._character - param1FormatRun._character;
/*     */     }
/*     */ 
/*     */     
/*     */     public int hashCode() {
/* 101 */       assert false : "hashCode not designed";
/* 102 */       return 42;
/*     */     }
/*     */     
/*     */     public String toString() {
/* 106 */       return "character=" + this._character + ",fontIndex=" + this._fontIndex;
/*     */     }
/*     */     
/*     */     public void serialize(LittleEndianOutput param1LittleEndianOutput) {
/* 110 */       param1LittleEndianOutput.writeShort(this._character);
/* 111 */       param1LittleEndianOutput.writeShort(this._fontIndex);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public static class ExtRst
/*     */     implements Comparable<ExtRst>
/*     */   {
/*     */     private short reserved;
/*     */     
/*     */     private short formattingFontIndex;
/*     */     
/*     */     private short formattingOptions;
/*     */     
/*     */     private int numberOfRuns;
/*     */     
/*     */     private String phoneticText;
/*     */     
/*     */     private UnicodeString.PhRun[] phRuns;
/*     */     private byte[] extraData;
/*     */     
/*     */     private void populateEmpty() {
/* 133 */       this.reserved = 1;
/* 134 */       this.phoneticText = "";
/* 135 */       this.phRuns = new UnicodeString.PhRun[0];
/* 136 */       this.extraData = new byte[0];
/*     */     }
/*     */     
/*     */     protected ExtRst() {
/* 140 */       populateEmpty();
/*     */     }
/*     */     protected ExtRst(LittleEndianInput param1LittleEndianInput, int param1Int) {
/* 143 */       this.reserved = param1LittleEndianInput.readShort();
/*     */ 
/*     */       
/* 146 */       if (this.reserved == -1) {
/* 147 */         populateEmpty();
/*     */         
/*     */         return;
/*     */       } 
/*     */       
/* 152 */       if (this.reserved != 1) {
/* 153 */         UnicodeString._logger.log(5, new Object[] { "Warning - ExtRst has wrong magic marker, expecting 1 but found " + this.reserved + " - ignoring" });
/*     */         
/* 155 */         for (byte b1 = 0; b1 < param1Int - 2; b1++) {
/* 156 */           param1LittleEndianInput.readByte();
/*     */         }
/*     */         
/* 159 */         populateEmpty();
/*     */         
/*     */         return;
/*     */       } 
/*     */       
/* 164 */       short s1 = param1LittleEndianInput.readShort();
/*     */       
/* 166 */       this.formattingFontIndex = param1LittleEndianInput.readShort();
/* 167 */       this.formattingOptions = param1LittleEndianInput.readShort();
/*     */ 
/*     */       
/* 170 */       this.numberOfRuns = param1LittleEndianInput.readUShort();
/* 171 */       short s2 = param1LittleEndianInput.readShort();
/*     */ 
/*     */       
/* 174 */       short s3 = param1LittleEndianInput.readShort();
/*     */       
/* 176 */       if (s2 == 0 && s3 > 0) {
/* 177 */         s3 = 0;
/*     */       }
/* 179 */       if (s2 != s3) {
/* 180 */         throw new IllegalStateException("The two length fields of the Phonetic Text don't agree! " + s2 + " vs " + s3);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 185 */       this.phoneticText = StringUtil.readUnicodeLE(param1LittleEndianInput, s2);
/*     */       
/* 187 */       int i = s1 - 4 - 6 - 2 * this.phoneticText.length();
/* 188 */       int j = i / 6;
/* 189 */       this.phRuns = new UnicodeString.PhRun[j]; int k;
/* 190 */       for (k = 0; k < this.phRuns.length; k++) {
/* 191 */         this.phRuns[k] = new UnicodeString.PhRun(param1LittleEndianInput);
/*     */       }
/*     */       
/* 194 */       k = i - j * 6;
/* 195 */       if (k < 0) {
/* 196 */         UnicodeString._logger.log(5, new Object[] { "Warning - ExtRst overran by " + (0 - k) + " bytes" });
/* 197 */         k = 0;
/*     */       } 
/* 199 */       this.extraData = new byte[k];
/* 200 */       for (byte b = 0; b < this.extraData.length; b++) {
/* 201 */         this.extraData[b] = param1LittleEndianInput.readByte();
/*     */       }
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected int getDataSize() {
/* 209 */       return 10 + 2 * this.phoneticText.length() + 6 * this.phRuns.length + this.extraData.length;
/*     */     }
/*     */     
/*     */     protected void serialize(ContinuableRecordOutput param1ContinuableRecordOutput) {
/* 213 */       int i = getDataSize();
/*     */       
/* 215 */       param1ContinuableRecordOutput.writeContinueIfRequired(8);
/* 216 */       param1ContinuableRecordOutput.writeShort(this.reserved);
/* 217 */       param1ContinuableRecordOutput.writeShort(i);
/* 218 */       param1ContinuableRecordOutput.writeShort(this.formattingFontIndex);
/* 219 */       param1ContinuableRecordOutput.writeShort(this.formattingOptions);
/*     */       
/* 221 */       param1ContinuableRecordOutput.writeContinueIfRequired(6);
/* 222 */       param1ContinuableRecordOutput.writeShort(this.numberOfRuns);
/* 223 */       param1ContinuableRecordOutput.writeShort(this.phoneticText.length());
/* 224 */       param1ContinuableRecordOutput.writeShort(this.phoneticText.length());
/*     */       
/* 226 */       param1ContinuableRecordOutput.writeContinueIfRequired(this.phoneticText.length() * 2);
/* 227 */       StringUtil.putUnicodeLE(this.phoneticText, (LittleEndianOutput)param1ContinuableRecordOutput);
/*     */       
/* 229 */       for (byte b = 0; b < this.phRuns.length; b++) {
/* 230 */         this.phRuns[b].serialize(param1ContinuableRecordOutput);
/*     */       }
/*     */       
/* 233 */       param1ContinuableRecordOutput.write(this.extraData);
/*     */     }
/*     */     
/*     */     public boolean equals(Object param1Object) {
/* 237 */       if (!(param1Object instanceof ExtRst)) {
/* 238 */         return false;
/*     */       }
/* 240 */       ExtRst extRst = (ExtRst)param1Object;
/* 241 */       return (compareTo(extRst) == 0);
/*     */     }
/*     */ 
/*     */     
/*     */     public int compareTo(ExtRst param1ExtRst) {
/* 246 */       int i = this.reserved - param1ExtRst.reserved;
/* 247 */       if (i != 0) {
/* 248 */         return i;
/*     */       }
/* 250 */       i = this.formattingFontIndex - param1ExtRst.formattingFontIndex;
/* 251 */       if (i != 0) {
/* 252 */         return i;
/*     */       }
/* 254 */       i = this.formattingOptions - param1ExtRst.formattingOptions;
/* 255 */       if (i != 0) {
/* 256 */         return i;
/*     */       }
/* 258 */       i = this.numberOfRuns - param1ExtRst.numberOfRuns;
/* 259 */       if (i != 0) {
/* 260 */         return i;
/*     */       }
/*     */       
/* 263 */       i = this.phoneticText.compareTo(param1ExtRst.phoneticText);
/* 264 */       if (i != 0) {
/* 265 */         return i;
/*     */       }
/*     */       
/* 268 */       i = this.phRuns.length - param1ExtRst.phRuns.length;
/* 269 */       if (i != 0) {
/* 270 */         return i;
/*     */       }
/* 272 */       for (byte b = 0; b < this.phRuns.length; b++) {
/* 273 */         i = (this.phRuns[b]).phoneticTextFirstCharacterOffset - (param1ExtRst.phRuns[b]).phoneticTextFirstCharacterOffset;
/* 274 */         if (i != 0) {
/* 275 */           return i;
/*     */         }
/* 277 */         i = (this.phRuns[b]).realTextFirstCharacterOffset - (param1ExtRst.phRuns[b]).realTextFirstCharacterOffset;
/* 278 */         if (i != 0) {
/* 279 */           return i;
/*     */         }
/* 281 */         i = (this.phRuns[b]).realTextLength - (param1ExtRst.phRuns[b]).realTextLength;
/* 282 */         if (i != 0) {
/* 283 */           return i;
/*     */         }
/*     */       } 
/*     */       
/* 287 */       i = Arrays.hashCode(this.extraData) - Arrays.hashCode(param1ExtRst.extraData);
/*     */       
/* 289 */       return i;
/*     */     }
/*     */ 
/*     */     
/*     */     public int hashCode() {
/* 294 */       short s = this.reserved;
/* 295 */       int i = 31 * s + this.formattingFontIndex;
/* 296 */       i = 31 * i + this.formattingOptions;
/* 297 */       i = 31 * i + this.numberOfRuns;
/* 298 */       i = 31 * i + this.phoneticText.hashCode();
/*     */       
/* 300 */       if (this.phRuns != null) {
/* 301 */         for (UnicodeString.PhRun phRun : this.phRuns) {
/* 302 */           i = 31 * i + phRun.phoneticTextFirstCharacterOffset;
/* 303 */           i = 31 * i + phRun.realTextFirstCharacterOffset;
/* 304 */           i = 31 * i + phRun.realTextLength;
/*     */         } 
/*     */       }
/* 307 */       return i;
/*     */     }
/*     */     
/*     */     protected ExtRst clone() {
/* 311 */       ExtRst extRst = new ExtRst();
/* 312 */       extRst.reserved = this.reserved;
/* 313 */       extRst.formattingFontIndex = this.formattingFontIndex;
/* 314 */       extRst.formattingOptions = this.formattingOptions;
/* 315 */       extRst.numberOfRuns = this.numberOfRuns;
/* 316 */       extRst.phoneticText = this.phoneticText;
/* 317 */       extRst.phRuns = new UnicodeString.PhRun[this.phRuns.length];
/* 318 */       for (byte b = 0; b < extRst.phRuns.length; b++) {
/* 319 */         extRst.phRuns[b] = new UnicodeString.PhRun((this.phRuns[b]).phoneticTextFirstCharacterOffset, (this.phRuns[b]).realTextFirstCharacterOffset, (this.phRuns[b]).realTextLength);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 325 */       return extRst;
/*     */     }
/*     */     
/*     */     public short getFormattingFontIndex() {
/* 329 */       return this.formattingFontIndex;
/*     */     }
/*     */     public short getFormattingOptions() {
/* 332 */       return this.formattingOptions;
/*     */     }
/*     */     public int getNumberOfRuns() {
/* 335 */       return this.numberOfRuns;
/*     */     }
/*     */     public String getPhoneticText() {
/* 338 */       return this.phoneticText;
/*     */     }
/*     */     public UnicodeString.PhRun[] getPhRuns() {
/* 341 */       return this.phRuns;
/*     */     }
/*     */   }
/*     */   
/*     */   public static class PhRun {
/*     */     private int phoneticTextFirstCharacterOffset;
/*     */     private int realTextFirstCharacterOffset;
/*     */     private int realTextLength;
/*     */     
/*     */     public PhRun(int param1Int1, int param1Int2, int param1Int3) {
/* 351 */       this.phoneticTextFirstCharacterOffset = param1Int1;
/* 352 */       this.realTextFirstCharacterOffset = param1Int2;
/* 353 */       this.realTextLength = param1Int3;
/*     */     }
/*     */     private PhRun(LittleEndianInput param1LittleEndianInput) {
/* 356 */       this.phoneticTextFirstCharacterOffset = param1LittleEndianInput.readUShort();
/* 357 */       this.realTextFirstCharacterOffset = param1LittleEndianInput.readUShort();
/* 358 */       this.realTextLength = param1LittleEndianInput.readUShort();
/*     */     }
/*     */     private void serialize(ContinuableRecordOutput param1ContinuableRecordOutput) {
/* 361 */       param1ContinuableRecordOutput.writeContinueIfRequired(6);
/* 362 */       param1ContinuableRecordOutput.writeShort(this.phoneticTextFirstCharacterOffset);
/* 363 */       param1ContinuableRecordOutput.writeShort(this.realTextFirstCharacterOffset);
/* 364 */       param1ContinuableRecordOutput.writeShort(this.realTextLength);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private UnicodeString() {}
/*     */ 
/*     */   
/*     */   public UnicodeString(String paramString) {
/* 374 */     setString(paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 381 */     int i = 0;
/* 382 */     if (this.field_3_string != null) {
/* 383 */       i = this.field_3_string.hashCode();
/*     */     }
/* 385 */     return this.field_1_charCount + i;
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
/*     */   public boolean equals(Object paramObject) {
/* 397 */     if (!(paramObject instanceof UnicodeString)) {
/* 398 */       return false;
/*     */     }
/* 400 */     UnicodeString unicodeString = (UnicodeString)paramObject;
/*     */ 
/*     */     
/* 403 */     if (this.field_1_charCount != unicodeString.field_1_charCount || this.field_2_optionflags != unicodeString.field_2_optionflags || !this.field_3_string.equals(unicodeString.field_3_string))
/*     */     {
/*     */       
/* 406 */       return false;
/*     */     }
/*     */ 
/*     */     
/* 410 */     if (this.field_4_format_runs == null)
/*     */     {
/* 412 */       return (unicodeString.field_4_format_runs == null); } 
/* 413 */     if (unicodeString.field_4_format_runs == null)
/*     */     {
/* 415 */       return false;
/*     */     }
/*     */ 
/*     */     
/* 419 */     int i = this.field_4_format_runs.size();
/* 420 */     if (i != unicodeString.field_4_format_runs.size()) {
/* 421 */       return false;
/*     */     }
/*     */     
/* 424 */     for (byte b = 0; b < i; b++) {
/* 425 */       FormatRun formatRun1 = this.field_4_format_runs.get(b);
/* 426 */       FormatRun formatRun2 = unicodeString.field_4_format_runs.get(b);
/*     */       
/* 428 */       if (!formatRun1.equals(formatRun2)) {
/* 429 */         return false;
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 434 */     if (this.field_5_ext_rst == null)
/* 435 */       return (unicodeString.field_5_ext_rst == null); 
/* 436 */     if (unicodeString.field_5_ext_rst == null) {
/* 437 */       return false;
/*     */     }
/*     */     
/* 440 */     return this.field_5_ext_rst.equals(unicodeString.field_5_ext_rst);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public UnicodeString(RecordInputStream paramRecordInputStream) {
/* 448 */     this.field_1_charCount = paramRecordInputStream.readShort();
/* 449 */     this.field_2_optionflags = paramRecordInputStream.readByte();
/*     */     
/* 451 */     short s = 0;
/* 452 */     int i = 0;
/*     */     
/* 454 */     if (isRichText()) {
/* 455 */       s = paramRecordInputStream.readShort();
/*     */     }
/*     */     
/* 458 */     if (isExtendedText()) {
/* 459 */       i = paramRecordInputStream.readInt();
/*     */     }
/*     */     
/* 462 */     boolean bool = ((this.field_2_optionflags & 0x1) == 0) ? true : false;
/* 463 */     int j = getCharCount();
/* 464 */     this.field_3_string = bool ? paramRecordInputStream.readCompressedUnicode(j) : paramRecordInputStream.readUnicodeLEString(j);
/*     */     
/* 466 */     if (isRichText() && s > 0) {
/* 467 */       this.field_4_format_runs = new ArrayList<FormatRun>(s);
/* 468 */       for (byte b = 0; b < s; b++) {
/* 469 */         this.field_4_format_runs.add(new FormatRun((LittleEndianInput)paramRecordInputStream));
/*     */       }
/*     */     } 
/*     */     
/* 473 */     if (isExtendedText() && i > 0) {
/* 474 */       this.field_5_ext_rst = new ExtRst((LittleEndianInput)new ContinuableRecordInput(paramRecordInputStream), i);
/* 475 */       if (this.field_5_ext_rst.getDataSize() + 4 != i) {
/* 476 */         _logger.log(5, new Object[] { "ExtRst was supposed to be " + i + " bytes long, but seems to actually be " + (this.field_5_ext_rst.getDataSize() + 4) });
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
/*     */   public int getCharCount() {
/* 490 */     if (this.field_1_charCount < 0) {
/* 491 */       return this.field_1_charCount + 65536;
/*     */     }
/* 493 */     return this.field_1_charCount;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public short getCharCountShort() {
/* 503 */     return this.field_1_charCount;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCharCount(short paramShort) {
/* 513 */     this.field_1_charCount = paramShort;
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
/*     */   public byte getOptionFlags() {
/* 526 */     return this.field_2_optionflags;
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
/*     */   public void setOptionFlags(byte paramByte) {
/* 539 */     this.field_2_optionflags = paramByte;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getString() {
/* 547 */     return this.field_3_string;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setString(String paramString) {
/* 557 */     this.field_3_string = paramString;
/* 558 */     setCharCount((short)this.field_3_string.length());
/*     */ 
/*     */ 
/*     */     
/* 562 */     boolean bool = false;
/* 563 */     int i = paramString.length();
/*     */     
/* 565 */     for (byte b = 0; b < i; b++) {
/* 566 */       if (paramString.charAt(b) > 'ÿ') {
/* 567 */         bool = true;
/*     */         break;
/*     */       } 
/*     */     } 
/* 571 */     if (bool) {
/*     */       
/* 573 */       this.field_2_optionflags = highByte.setByte(this.field_2_optionflags);
/*     */     } else {
/* 575 */       this.field_2_optionflags = highByte.clearByte(this.field_2_optionflags);
/*     */     } 
/*     */   }
/*     */   
/*     */   public int getFormatRunCount() {
/* 580 */     return (this.field_4_format_runs == null) ? 0 : this.field_4_format_runs.size();
/*     */   }
/*     */   
/*     */   public FormatRun getFormatRun(int paramInt) {
/* 584 */     if (this.field_4_format_runs == null) {
/* 585 */       return null;
/*     */     }
/* 587 */     if (paramInt < 0 || paramInt >= this.field_4_format_runs.size()) {
/* 588 */       return null;
/*     */     }
/* 590 */     return this.field_4_format_runs.get(paramInt);
/*     */   }
/*     */   
/*     */   private int findFormatRunAt(int paramInt) {
/* 594 */     int i = this.field_4_format_runs.size();
/* 595 */     for (byte b = 0; b < i; b++) {
/* 596 */       FormatRun formatRun = this.field_4_format_runs.get(b);
/* 597 */       if (formatRun._character == paramInt)
/* 598 */         return b; 
/* 599 */       if (formatRun._character > paramInt) {
/* 600 */         return -1;
/*     */       }
/*     */     } 
/* 603 */     return -1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void addFormatRun(FormatRun paramFormatRun) {
/* 612 */     if (this.field_4_format_runs == null) {
/* 613 */       this.field_4_format_runs = new ArrayList<FormatRun>();
/*     */     }
/*     */     
/* 616 */     int i = findFormatRunAt(paramFormatRun._character);
/* 617 */     if (i != -1) {
/* 618 */       this.field_4_format_runs.remove(i);
/*     */     }
/*     */     
/* 621 */     this.field_4_format_runs.add(paramFormatRun);
/*     */ 
/*     */     
/* 624 */     Collections.sort(this.field_4_format_runs);
/*     */ 
/*     */     
/* 627 */     this.field_2_optionflags = richText.setByte(this.field_2_optionflags);
/*     */   }
/*     */   
/*     */   public Iterator<FormatRun> formatIterator() {
/* 631 */     if (this.field_4_format_runs != null) {
/* 632 */       return this.field_4_format_runs.iterator();
/*     */     }
/* 634 */     return null;
/*     */   }
/*     */   
/*     */   public void removeFormatRun(FormatRun paramFormatRun) {
/* 638 */     this.field_4_format_runs.remove(paramFormatRun);
/* 639 */     if (this.field_4_format_runs.size() == 0) {
/* 640 */       this.field_4_format_runs = null;
/* 641 */       this.field_2_optionflags = richText.clearByte(this.field_2_optionflags);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void clearFormatting() {
/* 646 */     this.field_4_format_runs = null;
/* 647 */     this.field_2_optionflags = richText.clearByte(this.field_2_optionflags);
/*     */   }
/*     */ 
/*     */   
/*     */   public ExtRst getExtendedRst() {
/* 652 */     return this.field_5_ext_rst;
/*     */   }
/*     */   void setExtendedRst(ExtRst paramExtRst) {
/* 655 */     if (paramExtRst != null) {
/* 656 */       this.field_2_optionflags = extBit.setByte(this.field_2_optionflags);
/*     */     } else {
/* 658 */       this.field_2_optionflags = extBit.clearByte(this.field_2_optionflags);
/*     */     } 
/* 660 */     this.field_5_ext_rst = paramExtRst;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void swapFontUse(short paramShort1, short paramShort2) {
/* 671 */     for (FormatRun formatRun : this.field_4_format_runs) {
/* 672 */       if (formatRun._fontIndex == paramShort1) {
/* 673 */         formatRun._fontIndex = paramShort2;
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
/*     */   public String toString() {
/* 686 */     return getString();
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
/*     */   public String getDebugInfo() {
/* 698 */     StringBuffer stringBuffer = new StringBuffer();
/*     */     
/* 700 */     stringBuffer.append("[UNICODESTRING]\n");
/* 701 */     stringBuffer.append("    .charcount       = ").append(Integer.toHexString(getCharCount())).append("\n");
/*     */     
/* 703 */     stringBuffer.append("    .optionflags     = ").append(Integer.toHexString(getOptionFlags())).append("\n");
/*     */     
/* 705 */     stringBuffer.append("    .string          = ").append(getString()).append("\n");
/* 706 */     if (this.field_4_format_runs != null) {
/* 707 */       for (byte b = 0; b < this.field_4_format_runs.size(); b++) {
/* 708 */         FormatRun formatRun = this.field_4_format_runs.get(b);
/* 709 */         stringBuffer.append("      .format_run" + b + "          = ").append(formatRun.toString()).append("\n");
/*     */       } 
/*     */     }
/* 712 */     if (this.field_5_ext_rst != null) {
/* 713 */       stringBuffer.append("    .field_5_ext_rst          = ").append("\n");
/* 714 */       stringBuffer.append(this.field_5_ext_rst.toString()).append("\n");
/*     */     } 
/* 716 */     stringBuffer.append("[/UNICODESTRING]\n");
/* 717 */     return stringBuffer.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void serialize(ContinuableRecordOutput paramContinuableRecordOutput) {
/* 726 */     int i = 0;
/* 727 */     int j = 0;
/* 728 */     if (isRichText() && this.field_4_format_runs != null) {
/* 729 */       i = this.field_4_format_runs.size();
/*     */     }
/* 731 */     if (isExtendedText() && this.field_5_ext_rst != null) {
/* 732 */       j = 4 + this.field_5_ext_rst.getDataSize();
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 737 */     paramContinuableRecordOutput.writeString(this.field_3_string, i, j);
/*     */     
/* 739 */     if (i > 0)
/*     */     {
/*     */       
/* 742 */       for (byte b = 0; b < i; b++) {
/* 743 */         if (paramContinuableRecordOutput.getAvailableSpace() < 4) {
/* 744 */           paramContinuableRecordOutput.writeContinue();
/*     */         }
/* 746 */         FormatRun formatRun = this.field_4_format_runs.get(b);
/* 747 */         formatRun.serialize((LittleEndianOutput)paramContinuableRecordOutput);
/*     */       } 
/*     */     }
/*     */     
/* 751 */     if (j > 0) {
/* 752 */       this.field_5_ext_rst.serialize(paramContinuableRecordOutput);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public int compareTo(UnicodeString paramUnicodeString) {
/* 758 */     int i = getString().compareTo(paramUnicodeString.getString());
/*     */ 
/*     */     
/* 761 */     if (i != 0) {
/* 762 */       return i;
/*     */     }
/*     */ 
/*     */     
/* 766 */     if (this.field_4_format_runs == null)
/*     */     {
/*     */       
/* 769 */       return (paramUnicodeString.field_4_format_runs == null) ? 0 : 1; } 
/* 770 */     if (paramUnicodeString.field_4_format_runs == null)
/*     */     {
/* 772 */       return -1;
/*     */     }
/*     */ 
/*     */     
/* 776 */     int j = this.field_4_format_runs.size();
/* 777 */     if (j != paramUnicodeString.field_4_format_runs.size()) {
/* 778 */       return j - paramUnicodeString.field_4_format_runs.size();
/*     */     }
/*     */     
/* 781 */     for (byte b = 0; b < j; b++) {
/* 782 */       FormatRun formatRun1 = this.field_4_format_runs.get(b);
/* 783 */       FormatRun formatRun2 = paramUnicodeString.field_4_format_runs.get(b);
/*     */       
/* 785 */       i = formatRun1.compareTo(formatRun2);
/* 786 */       if (i != 0) {
/* 787 */         return i;
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 792 */     if (this.field_5_ext_rst == null)
/* 793 */       return (paramUnicodeString.field_5_ext_rst == null) ? 0 : 1; 
/* 794 */     if (paramUnicodeString.field_5_ext_rst == null) {
/* 795 */       return -1;
/*     */     }
/* 797 */     return this.field_5_ext_rst.compareTo(paramUnicodeString.field_5_ext_rst);
/*     */   }
/*     */ 
/*     */   
/*     */   private boolean isRichText() {
/* 802 */     return richText.isSet(getOptionFlags());
/*     */   }
/*     */   
/*     */   private boolean isExtendedText() {
/* 806 */     return extBit.isSet(getOptionFlags());
/*     */   }
/*     */   
/*     */   public Object clone() {
/* 810 */     UnicodeString unicodeString = new UnicodeString();
/* 811 */     unicodeString.field_1_charCount = this.field_1_charCount;
/* 812 */     unicodeString.field_2_optionflags = this.field_2_optionflags;
/* 813 */     unicodeString.field_3_string = this.field_3_string;
/* 814 */     if (this.field_4_format_runs != null) {
/* 815 */       unicodeString.field_4_format_runs = new ArrayList<FormatRun>();
/* 816 */       for (FormatRun formatRun : this.field_4_format_runs) {
/* 817 */         unicodeString.field_4_format_runs.add(new FormatRun(formatRun._character, formatRun._fontIndex));
/*     */       }
/*     */     } 
/* 820 */     if (this.field_5_ext_rst != null) {
/* 821 */       unicodeString.field_5_ext_rst = this.field_5_ext_rst.clone();
/*     */     }
/*     */     
/* 824 */     return unicodeString;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\common\UnicodeString.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */