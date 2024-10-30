/*     */ package org.apache.poi.hssf.record;
/*     */ 
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.DataOutputStream;
/*     */ import java.io.IOException;
/*     */ import org.apache.poi.ss.util.CellRangeAddress;
/*     */ import org.apache.poi.util.HexDump;
/*     */ import org.apache.poi.util.HexRead;
/*     */ import org.apache.poi.util.LittleEndianByteArrayInputStream;
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
/*     */ public final class HyperlinkRecord
/*     */   extends StandardRecord
/*     */   implements Cloneable
/*     */ {
/*     */   public static final short sid = 440;
/*  41 */   private static POILogger logger = POILogFactory.getLogger(HyperlinkRecord.class);
/*     */   
/*     */   static final int HLINK_URL = 1;
/*     */   
/*     */   static final int HLINK_ABS = 2;
/*     */   
/*     */   static final int HLINK_LABEL = 20;
/*     */   
/*     */   static final int HLINK_PLACE = 8;
/*     */   
/*     */   private static final int HLINK_TARGET_FRAME = 128;
/*     */   private static final int HLINK_UNC_PATH = 256;
/*     */   
/*     */   static final class GUID
/*     */   {
/*     */     private static final int TEXT_FORMAT_LENGTH = 36;
/*     */     public static final int ENCODED_SIZE = 16;
/*     */     private final int _d1;
/*     */     private final int _d2;
/*     */     private final int _d3;
/*     */     private final long _d4;
/*     */     
/*     */     public GUID(LittleEndianInput param1LittleEndianInput) {
/*  64 */       this(param1LittleEndianInput.readInt(), param1LittleEndianInput.readUShort(), param1LittleEndianInput.readUShort(), param1LittleEndianInput.readLong());
/*     */     }
/*     */     
/*     */     public GUID(int param1Int1, int param1Int2, int param1Int3, long param1Long) {
/*  68 */       this._d1 = param1Int1;
/*  69 */       this._d2 = param1Int2;
/*  70 */       this._d3 = param1Int3;
/*  71 */       this._d4 = param1Long;
/*     */     }
/*     */     
/*     */     public void serialize(LittleEndianOutput param1LittleEndianOutput) {
/*  75 */       param1LittleEndianOutput.writeInt(this._d1);
/*  76 */       param1LittleEndianOutput.writeShort(this._d2);
/*  77 */       param1LittleEndianOutput.writeShort(this._d3);
/*  78 */       param1LittleEndianOutput.writeLong(this._d4);
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean equals(Object param1Object) {
/*  83 */       if (!(param1Object instanceof GUID)) {
/*  84 */         return false;
/*     */       }
/*  86 */       GUID gUID = (GUID)param1Object;
/*  87 */       return (this._d1 == gUID._d1 && this._d2 == gUID._d2 && this._d3 == gUID._d3 && this._d4 == gUID._d4);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public int hashCode() {
/*  93 */       assert false : "hashCode not designed";
/*  94 */       return 42;
/*     */     }
/*     */     
/*     */     public int getD1() {
/*  98 */       return this._d1;
/*     */     }
/*     */     
/*     */     public int getD2() {
/* 102 */       return this._d2;
/*     */     }
/*     */     
/*     */     public int getD3() {
/* 106 */       return this._d3;
/*     */     }
/*     */ 
/*     */     
/*     */     public long getD4() {
/* 111 */       ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(8);
/*     */       try {
/* 113 */         (new DataOutputStream(byteArrayOutputStream)).writeLong(this._d4);
/* 114 */       } catch (IOException iOException) {
/* 115 */         throw new RuntimeException(iOException);
/*     */       } 
/* 117 */       byte[] arrayOfByte = byteArrayOutputStream.toByteArray();
/* 118 */       return (new LittleEndianByteArrayInputStream(arrayOfByte)).readLong();
/*     */     }
/*     */ 
/*     */     
/*     */     public String formatAsString() {
/* 123 */       StringBuilder stringBuilder = new StringBuilder(36);
/*     */       
/* 125 */       int i = "0x".length();
/* 126 */       stringBuilder.append(HexDump.intToHex(this._d1).substring(i));
/* 127 */       stringBuilder.append("-");
/* 128 */       stringBuilder.append(HexDump.shortToHex(this._d2).substring(i));
/* 129 */       stringBuilder.append("-");
/* 130 */       stringBuilder.append(HexDump.shortToHex(this._d3).substring(i));
/* 131 */       stringBuilder.append("-");
/* 132 */       String str = HexDump.longToHex(getD4());
/* 133 */       stringBuilder.append(str.substring(i, i + 4));
/* 134 */       stringBuilder.append("-");
/* 135 */       stringBuilder.append(str.substring(i + 4));
/* 136 */       return stringBuilder.toString();
/*     */     }
/*     */ 
/*     */     
/*     */     public String toString() {
/* 141 */       StringBuilder stringBuilder = new StringBuilder(64);
/* 142 */       stringBuilder.append(getClass().getName()).append(" [");
/* 143 */       stringBuilder.append(formatAsString());
/* 144 */       stringBuilder.append("]");
/* 145 */       return stringBuilder.toString();
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public static GUID parse(String param1String) {
/* 155 */       char[] arrayOfChar = param1String.toCharArray();
/* 156 */       if (arrayOfChar.length != 36) {
/* 157 */         throw new RecordFormatException("supplied text is the wrong length for a GUID");
/*     */       }
/* 159 */       int i = (parseShort(arrayOfChar, 0) << 16) + (parseShort(arrayOfChar, 4) << 0);
/* 160 */       int j = parseShort(arrayOfChar, 9);
/* 161 */       int k = parseShort(arrayOfChar, 14);
/* 162 */       for (byte b = 23; b > 19; b--) {
/* 163 */         arrayOfChar[b] = arrayOfChar[b - 1];
/*     */       }
/* 165 */       long l = parseLELong(arrayOfChar, 20);
/*     */       
/* 167 */       return new GUID(i, j, k, l);
/*     */     }
/*     */     
/*     */     private static long parseLELong(char[] param1ArrayOfchar, int param1Int) {
/* 171 */       long l = 0L;
/* 172 */       for (int i = param1Int + 14; i >= param1Int; i -= 2) {
/* 173 */         l <<= 4L;
/* 174 */         l += parseHexChar(param1ArrayOfchar[i + 0]);
/* 175 */         l <<= 4L;
/* 176 */         l += parseHexChar(param1ArrayOfchar[i + 1]);
/*     */       } 
/* 178 */       return l;
/*     */     }
/*     */     
/*     */     private static int parseShort(char[] param1ArrayOfchar, int param1Int) {
/* 182 */       int i = 0;
/* 183 */       for (byte b = 0; b < 4; b++) {
/* 184 */         i <<= 4;
/* 185 */         i += parseHexChar(param1ArrayOfchar[param1Int + b]);
/*     */       } 
/* 187 */       return i;
/*     */     }
/*     */     
/*     */     private static int parseHexChar(char param1Char) {
/* 191 */       if (param1Char >= '0' && param1Char <= '9') {
/* 192 */         return param1Char - 48;
/*     */       }
/* 194 */       if (param1Char >= 'A' && param1Char <= 'F') {
/* 195 */         return param1Char - 65 + 10;
/*     */       }
/* 197 */       if (param1Char >= 'a' && param1Char <= 'f') {
/* 198 */         return param1Char - 97 + 10;
/*     */       }
/* 200 */       throw new RecordFormatException("Bad hex char '" + param1Char + "'");
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
/* 215 */   static final GUID STD_MONIKER = GUID.parse("79EAC9D0-BAF9-11CE-8C82-00AA004BA90B");
/* 216 */   static final GUID URL_MONIKER = GUID.parse("79EAC9E0-BAF9-11CE-8C82-00AA004BA90B");
/* 217 */   static final GUID FILE_MONIKER = GUID.parse("00000303-0000-0000-C000-000000000046");
/*     */   
/* 219 */   private static final byte[] URL_TAIL = HexRead.readFromString("79 58 81 F4  3B 1D 7F 48   AF 2C 82 5D  C4 85 27 63   00 00 00 00  A5 AB 00 00");
/*     */   
/* 221 */   private static final byte[] FILE_TAIL = HexRead.readFromString("FF FF AD DE  00 00 00 00   00 00 00 00  00 00 00 00   00 00 00 00  00 00 00 00");
/*     */   
/* 223 */   private static final int TAIL_SIZE = FILE_TAIL.length;
/*     */ 
/*     */ 
/*     */   
/*     */   private CellRangeAddress _range;
/*     */ 
/*     */   
/*     */   private GUID _guid;
/*     */ 
/*     */   
/*     */   private int _fileOpts;
/*     */ 
/*     */   
/*     */   private int _linkOpts;
/*     */ 
/*     */   
/*     */   private String _label;
/*     */ 
/*     */   
/*     */   private String _targetFrame;
/*     */ 
/*     */   
/*     */   private GUID _moniker;
/*     */ 
/*     */   
/*     */   private String _shortFilename;
/*     */ 
/*     */   
/*     */   private String _address;
/*     */ 
/*     */   
/*     */   private String _textMark;
/*     */ 
/*     */   
/*     */   private byte[] _uninterpretedTail;
/*     */ 
/*     */ 
/*     */   
/*     */   public HyperlinkRecord() {}
/*     */ 
/*     */ 
/*     */   
/*     */   public int getFirstColumn() {
/* 266 */     return this._range.getFirstColumn();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setFirstColumn(int paramInt) {
/* 275 */     this._range.setFirstColumn(paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getLastColumn() {
/* 282 */     return this._range.getLastColumn();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setLastColumn(int paramInt) {
/* 291 */     this._range.setLastColumn(paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getFirstRow() {
/* 298 */     return this._range.getFirstRow();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setFirstRow(int paramInt) {
/* 307 */     this._range.setFirstRow(paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getLastRow() {
/* 314 */     return this._range.getLastRow();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setLastRow(int paramInt) {
/* 323 */     this._range.setLastRow(paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   GUID getGuid() {
/* 330 */     return this._guid;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   GUID getMoniker() {
/* 338 */     return this._moniker;
/*     */   }
/*     */   
/*     */   private static String cleanString(String paramString) {
/* 342 */     if (paramString == null) {
/* 343 */       return null;
/*     */     }
/* 345 */     int i = paramString.indexOf(false);
/* 346 */     if (i < 0) {
/* 347 */       return paramString;
/*     */     }
/* 349 */     return paramString.substring(0, i);
/*     */   }
/*     */   private static String appendNullTerm(String paramString) {
/* 352 */     if (paramString == null) {
/* 353 */       return null;
/*     */     }
/* 355 */     return paramString + Character.MIN_VALUE;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getLabel() {
/* 364 */     return cleanString(this._label);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setLabel(String paramString) {
/* 373 */     this._label = appendNullTerm(paramString);
/*     */   }
/*     */   public String getTargetFrame() {
/* 376 */     return cleanString(this._targetFrame);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getAddress() {
/* 385 */     if ((this._linkOpts & 0x1) != 0 && FILE_MONIKER.equals(this._moniker))
/* 386 */       return cleanString((this._address != null) ? this._address : this._shortFilename); 
/* 387 */     if ((this._linkOpts & 0x8) != 0) {
/* 388 */       return cleanString(this._textMark);
/*     */     }
/* 390 */     return cleanString(this._address);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAddress(String paramString) {
/* 400 */     if ((this._linkOpts & 0x1) != 0 && FILE_MONIKER.equals(this._moniker)) {
/* 401 */       this._shortFilename = appendNullTerm(paramString);
/* 402 */     } else if ((this._linkOpts & 0x8) != 0) {
/* 403 */       this._textMark = appendNullTerm(paramString);
/*     */     } else {
/* 405 */       this._address = appendNullTerm(paramString);
/*     */     } 
/*     */   }
/*     */   
/*     */   public String getShortFilename() {
/* 410 */     return cleanString(this._shortFilename);
/*     */   }
/*     */   
/*     */   public void setShortFilename(String paramString) {
/* 414 */     this._shortFilename = appendNullTerm(paramString);
/*     */   }
/*     */   
/*     */   public String getTextMark() {
/* 418 */     return cleanString(this._textMark);
/*     */   }
/*     */   public void setTextMark(String paramString) {
/* 421 */     this._textMark = appendNullTerm(paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   int getLinkOptions() {
/* 432 */     return this._linkOpts;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getLabelOptions() {
/* 439 */     return 2;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getFileOptions() {
/* 446 */     return this._fileOpts;
/*     */   }
/*     */ 
/*     */   
/*     */   public HyperlinkRecord(RecordInputStream paramRecordInputStream) {
/* 451 */     this._range = new CellRangeAddress(paramRecordInputStream);
/*     */     
/* 453 */     this._guid = new GUID(paramRecordInputStream);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 459 */     int i = paramRecordInputStream.readInt();
/* 460 */     if (i != 2) {
/* 461 */       throw new RecordFormatException("Stream Version must be 0x2 but found " + i);
/*     */     }
/* 463 */     this._linkOpts = paramRecordInputStream.readInt();
/*     */     
/* 465 */     if ((this._linkOpts & 0x14) != 0) {
/* 466 */       int j = paramRecordInputStream.readInt();
/* 467 */       this._label = paramRecordInputStream.readUnicodeLEString(j);
/*     */     } 
/*     */     
/* 470 */     if ((this._linkOpts & 0x80) != 0) {
/* 471 */       int j = paramRecordInputStream.readInt();
/* 472 */       this._targetFrame = paramRecordInputStream.readUnicodeLEString(j);
/*     */     } 
/*     */     
/* 475 */     if ((this._linkOpts & 0x1) != 0 && (this._linkOpts & 0x100) != 0) {
/* 476 */       this._moniker = null;
/* 477 */       int j = paramRecordInputStream.readInt();
/* 478 */       this._address = paramRecordInputStream.readUnicodeLEString(j);
/*     */     } 
/*     */     
/* 481 */     if ((this._linkOpts & 0x1) != 0 && (this._linkOpts & 0x100) == 0) {
/* 482 */       this._moniker = new GUID(paramRecordInputStream);
/*     */       
/* 484 */       if (URL_MONIKER.equals(this._moniker)) {
/* 485 */         int j = paramRecordInputStream.readInt();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 492 */         int k = paramRecordInputStream.remaining();
/* 493 */         if (j == k) {
/* 494 */           int m = j / 2;
/* 495 */           this._address = paramRecordInputStream.readUnicodeLEString(m);
/*     */         } else {
/* 497 */           int m = (j - TAIL_SIZE) / 2;
/* 498 */           this._address = paramRecordInputStream.readUnicodeLEString(m);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 507 */           this._uninterpretedTail = readTail(URL_TAIL, paramRecordInputStream);
/*     */         } 
/* 509 */       } else if (FILE_MONIKER.equals(this._moniker)) {
/* 510 */         this._fileOpts = paramRecordInputStream.readShort();
/*     */         
/* 512 */         int j = paramRecordInputStream.readInt();
/* 513 */         this._shortFilename = StringUtil.readCompressedUnicode(paramRecordInputStream, j);
/* 514 */         this._uninterpretedTail = readTail(FILE_TAIL, paramRecordInputStream);
/* 515 */         int k = paramRecordInputStream.readInt();
/* 516 */         if (k > 0) {
/* 517 */           int m = paramRecordInputStream.readInt();
/*     */ 
/*     */ 
/*     */           
/* 521 */           paramRecordInputStream.readUShort();
/*     */           
/* 523 */           this._address = StringUtil.readUnicodeLE(paramRecordInputStream, m / 2);
/*     */         } else {
/* 525 */           this._address = null;
/*     */         } 
/* 527 */       } else if (STD_MONIKER.equals(this._moniker)) {
/* 528 */         this._fileOpts = paramRecordInputStream.readShort();
/*     */         
/* 530 */         int j = paramRecordInputStream.readInt();
/*     */         
/* 532 */         byte[] arrayOfByte = new byte[j];
/* 533 */         paramRecordInputStream.readFully(arrayOfByte);
/*     */         
/* 535 */         this._address = new String(arrayOfByte, StringUtil.UTF8);
/*     */       } 
/*     */     } 
/*     */     
/* 539 */     if ((this._linkOpts & 0x8) != 0) {
/*     */       
/* 541 */       int j = paramRecordInputStream.readInt();
/* 542 */       this._textMark = paramRecordInputStream.readUnicodeLEString(j);
/*     */     } 
/*     */     
/* 545 */     if (paramRecordInputStream.remaining() > 0) {
/* 546 */       logger.log(5, new Object[] { "Hyperlink data remains: " + paramRecordInputStream.remaining() + " : " + HexDump.toHex(paramRecordInputStream.readRemainder()) });
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void serialize(LittleEndianOutput paramLittleEndianOutput) {
/* 555 */     this._range.serialize(paramLittleEndianOutput);
/*     */     
/* 557 */     this._guid.serialize(paramLittleEndianOutput);
/* 558 */     paramLittleEndianOutput.writeInt(2);
/* 559 */     paramLittleEndianOutput.writeInt(this._linkOpts);
/*     */     
/* 561 */     if ((this._linkOpts & 0x14) != 0) {
/* 562 */       paramLittleEndianOutput.writeInt(this._label.length());
/* 563 */       StringUtil.putUnicodeLE(this._label, paramLittleEndianOutput);
/*     */     } 
/* 565 */     if ((this._linkOpts & 0x80) != 0) {
/* 566 */       paramLittleEndianOutput.writeInt(this._targetFrame.length());
/* 567 */       StringUtil.putUnicodeLE(this._targetFrame, paramLittleEndianOutput);
/*     */     } 
/*     */     
/* 570 */     if ((this._linkOpts & 0x1) != 0 && (this._linkOpts & 0x100) != 0) {
/* 571 */       paramLittleEndianOutput.writeInt(this._address.length());
/* 572 */       StringUtil.putUnicodeLE(this._address, paramLittleEndianOutput);
/*     */     } 
/*     */     
/* 575 */     if ((this._linkOpts & 0x1) != 0 && (this._linkOpts & 0x100) == 0) {
/* 576 */       this._moniker.serialize(paramLittleEndianOutput);
/* 577 */       if (URL_MONIKER.equals(this._moniker)) {
/* 578 */         if (this._uninterpretedTail == null) {
/* 579 */           paramLittleEndianOutput.writeInt(this._address.length() * 2);
/* 580 */           StringUtil.putUnicodeLE(this._address, paramLittleEndianOutput);
/*     */         } else {
/* 582 */           paramLittleEndianOutput.writeInt(this._address.length() * 2 + TAIL_SIZE);
/* 583 */           StringUtil.putUnicodeLE(this._address, paramLittleEndianOutput);
/* 584 */           writeTail(this._uninterpretedTail, paramLittleEndianOutput);
/*     */         } 
/* 586 */       } else if (FILE_MONIKER.equals(this._moniker)) {
/* 587 */         paramLittleEndianOutput.writeShort(this._fileOpts);
/* 588 */         paramLittleEndianOutput.writeInt(this._shortFilename.length());
/* 589 */         StringUtil.putCompressedUnicode(this._shortFilename, paramLittleEndianOutput);
/* 590 */         writeTail(this._uninterpretedTail, paramLittleEndianOutput);
/* 591 */         if (this._address == null) {
/* 592 */           paramLittleEndianOutput.writeInt(0);
/*     */         } else {
/* 594 */           int i = this._address.length() * 2;
/* 595 */           paramLittleEndianOutput.writeInt(i + 6);
/* 596 */           paramLittleEndianOutput.writeInt(i);
/* 597 */           paramLittleEndianOutput.writeShort(3);
/* 598 */           StringUtil.putUnicodeLE(this._address, paramLittleEndianOutput);
/*     */         } 
/*     */       } 
/*     */     } 
/* 602 */     if ((this._linkOpts & 0x8) != 0) {
/* 603 */       paramLittleEndianOutput.writeInt(this._textMark.length());
/* 604 */       StringUtil.putUnicodeLE(this._textMark, paramLittleEndianOutput);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected int getDataSize() {
/* 610 */     int i = 0;
/* 611 */     i += true;
/* 612 */     i += true;
/* 613 */     i += true;
/* 614 */     i += true;
/* 615 */     if ((this._linkOpts & 0x14) != 0) {
/* 616 */       i += true;
/* 617 */       i += this._label.length() * 2;
/*     */     } 
/* 619 */     if ((this._linkOpts & 0x80) != 0) {
/* 620 */       i += 4;
/* 621 */       i += this._targetFrame.length() * 2;
/*     */     } 
/* 623 */     if ((this._linkOpts & 0x1) != 0 && (this._linkOpts & 0x100) != 0) {
/* 624 */       i += 4;
/* 625 */       i += this._address.length() * 2;
/*     */     } 
/* 627 */     if ((this._linkOpts & 0x1) != 0 && (this._linkOpts & 0x100) == 0) {
/* 628 */       i += 16;
/* 629 */       if (URL_MONIKER.equals(this._moniker)) {
/* 630 */         i += 4;
/* 631 */         i += this._address.length() * 2;
/* 632 */         if (this._uninterpretedTail != null) {
/* 633 */           i += TAIL_SIZE;
/*     */         }
/* 635 */       } else if (FILE_MONIKER.equals(this._moniker)) {
/* 636 */         i += 2;
/* 637 */         i += 4;
/* 638 */         i += this._shortFilename.length();
/* 639 */         i += TAIL_SIZE;
/* 640 */         i += 4;
/* 641 */         if (this._address != null) {
/* 642 */           i += 6;
/* 643 */           i += this._address.length() * 2;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 648 */     if ((this._linkOpts & 0x8) != 0) {
/* 649 */       i += 4;
/* 650 */       i += this._textMark.length() * 2;
/*     */     } 
/* 652 */     return i;
/*     */   }
/*     */ 
/*     */   
/*     */   private static byte[] readTail(byte[] paramArrayOfbyte, LittleEndianInput paramLittleEndianInput) {
/* 657 */     byte[] arrayOfByte = new byte[TAIL_SIZE];
/* 658 */     paramLittleEndianInput.readFully(arrayOfByte);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 667 */     return arrayOfByte;
/*     */   }
/*     */   private static void writeTail(byte[] paramArrayOfbyte, LittleEndianOutput paramLittleEndianOutput) {
/* 670 */     paramLittleEndianOutput.write(paramArrayOfbyte);
/*     */   }
/*     */ 
/*     */   
/*     */   public short getSid() {
/* 675 */     return 440;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 681 */     StringBuffer stringBuffer = new StringBuffer();
/*     */     
/* 683 */     stringBuffer.append("[HYPERLINK RECORD]\n");
/* 684 */     stringBuffer.append("    .range   = ").append(this._range.formatAsString()).append("\n");
/* 685 */     stringBuffer.append("    .guid    = ").append(this._guid.formatAsString()).append("\n");
/* 686 */     stringBuffer.append("    .linkOpts= ").append(HexDump.intToHex(this._linkOpts)).append("\n");
/* 687 */     stringBuffer.append("    .label   = ").append(getLabel()).append("\n");
/* 688 */     if ((this._linkOpts & 0x80) != 0) {
/* 689 */       stringBuffer.append("    .targetFrame= ").append(getTargetFrame()).append("\n");
/*     */     }
/* 691 */     if ((this._linkOpts & 0x1) != 0 && this._moniker != null) {
/* 692 */       stringBuffer.append("    .moniker   = ").append(this._moniker.formatAsString()).append("\n");
/*     */     }
/* 694 */     if ((this._linkOpts & 0x8) != 0) {
/* 695 */       stringBuffer.append("    .textMark= ").append(getTextMark()).append("\n");
/*     */     }
/* 697 */     stringBuffer.append("    .address   = ").append(getAddress()).append("\n");
/* 698 */     stringBuffer.append("[/HYPERLINK RECORD]\n");
/* 699 */     return stringBuffer.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isUrlLink() {
/* 708 */     return ((this._linkOpts & 0x1) > 0 && (this._linkOpts & 0x2) > 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isFileLink() {
/* 717 */     return ((this._linkOpts & 0x1) > 0 && (this._linkOpts & 0x2) == 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isDocumentLink() {
/* 726 */     return ((this._linkOpts & 0x8) > 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void newUrlLink() {
/* 733 */     this._range = new CellRangeAddress(0, 0, 0, 0);
/* 734 */     this._guid = STD_MONIKER;
/* 735 */     this._linkOpts = 23;
/* 736 */     setLabel("");
/* 737 */     this._moniker = URL_MONIKER;
/* 738 */     setAddress("");
/* 739 */     this._uninterpretedTail = URL_TAIL;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void newFileLink() {
/* 746 */     this._range = new CellRangeAddress(0, 0, 0, 0);
/* 747 */     this._guid = STD_MONIKER;
/* 748 */     this._linkOpts = 21;
/* 749 */     this._fileOpts = 0;
/* 750 */     setLabel("");
/* 751 */     this._moniker = FILE_MONIKER;
/* 752 */     setAddress(null);
/* 753 */     setShortFilename("");
/* 754 */     this._uninterpretedTail = FILE_TAIL;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void newDocumentLink() {
/* 761 */     this._range = new CellRangeAddress(0, 0, 0, 0);
/* 762 */     this._guid = STD_MONIKER;
/* 763 */     this._linkOpts = 28;
/* 764 */     setLabel("");
/* 765 */     this._moniker = FILE_MONIKER;
/* 766 */     setAddress("");
/* 767 */     setTextMark("");
/*     */   }
/*     */ 
/*     */   
/*     */   public HyperlinkRecord clone() {
/* 772 */     HyperlinkRecord hyperlinkRecord = new HyperlinkRecord();
/* 773 */     hyperlinkRecord._range = this._range.copy();
/* 774 */     hyperlinkRecord._guid = this._guid;
/* 775 */     hyperlinkRecord._linkOpts = this._linkOpts;
/* 776 */     hyperlinkRecord._fileOpts = this._fileOpts;
/* 777 */     hyperlinkRecord._label = this._label;
/* 778 */     hyperlinkRecord._address = this._address;
/* 779 */     hyperlinkRecord._moniker = this._moniker;
/* 780 */     hyperlinkRecord._shortFilename = this._shortFilename;
/* 781 */     hyperlinkRecord._targetFrame = this._targetFrame;
/* 782 */     hyperlinkRecord._textMark = this._textMark;
/* 783 */     hyperlinkRecord._uninterpretedTail = this._uninterpretedTail;
/* 784 */     return hyperlinkRecord;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\HyperlinkRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */