/*     */ package org.apache.poi.ddf;
/*     */ 
/*     */ import java.io.PrintWriter;
/*     */ import java.util.Collections;
/*     */ import java.util.List;
/*     */ import org.apache.poi.util.BitField;
/*     */ import org.apache.poi.util.BitFieldFactory;
/*     */ import org.apache.poi.util.HexDump;
/*     */ import org.apache.poi.util.Internal;
/*     */ import org.apache.poi.util.LittleEndian;
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
/*     */ public abstract class EscherRecord
/*     */   implements Cloneable
/*     */ {
/*  36 */   private static final BitField fInstance = BitFieldFactory.getInstance(65520);
/*  37 */   private static final BitField fVersion = BitFieldFactory.getInstance(15);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private short _options;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private short _recordId;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected int fillFields(byte[] paramArrayOfbyte, EscherRecordFactory paramEscherRecordFactory) {
/*  60 */     return fillFields(paramArrayOfbyte, 0, paramEscherRecordFactory);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected int readHeader(byte[] paramArrayOfbyte, int paramInt) {
/*  85 */     this._options = LittleEndian.getShort(paramArrayOfbyte, paramInt);
/*  86 */     this._recordId = LittleEndian.getShort(paramArrayOfbyte, paramInt + 2);
/*  87 */     return LittleEndian.getInt(paramArrayOfbyte, paramInt + 4);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected static short readInstance(byte[] paramArrayOfbyte, int paramInt) {
/*  97 */     short s = LittleEndian.getShort(paramArrayOfbyte, paramInt);
/*  98 */     return fInstance.getShortValue(s);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isContainerRecord() {
/* 107 */     return (getVersion() == 15);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Internal
/*     */   public short getOptions() {
/* 119 */     return this._options;
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
/*     */   @Internal
/*     */   public void setOptions(short paramShort) {
/* 134 */     setVersion(fVersion.getShortValue(paramShort));
/* 135 */     setInstance(fInstance.getShortValue(paramShort));
/* 136 */     this._options = paramShort;
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
/*     */   public byte[] serialize() {
/* 148 */     byte[] arrayOfByte = new byte[getRecordSize()];
/*     */     
/* 150 */     serialize(0, arrayOfByte);
/* 151 */     return arrayOfByte;
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
/*     */   public int serialize(int paramInt, byte[] paramArrayOfbyte) {
/* 166 */     return serialize(paramInt, paramArrayOfbyte, new NullEscherSerializationListener());
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
/*     */   public short getRecordId() {
/* 196 */     return this._recordId;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRecordId(short paramShort) {
/* 205 */     this._recordId = paramShort;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<EscherRecord> getChildRecords() {
/* 215 */     return Collections.emptyList();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setChildRecords(List<EscherRecord> paramList) {
/* 224 */     throw new UnsupportedOperationException("This record does not support child records.");
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
/*     */   public EscherRecord clone() throws CloneNotSupportedException {
/* 236 */     return (EscherRecord)super.clone();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public EscherRecord getChild(int paramInt) {
/* 246 */     return getChildRecords().get(paramInt);
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
/*     */   public void display(PrintWriter paramPrintWriter, int paramInt) {
/* 258 */     for (byte b = 0; b < paramInt * 4; ) { paramPrintWriter.print(' '); b++; }
/* 259 */      paramPrintWriter.println(getRecordName());
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
/*     */   public short getInstance() {
/* 276 */     return fInstance.getShortValue(this._options);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setInstance(short paramShort) {
/* 286 */     this._options = fInstance.setShortValue(this._options, paramShort);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public short getVersion() {
/* 296 */     return fVersion.getShortValue(this._options);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setVersion(short paramShort) {
/* 306 */     this._options = fVersion.setShortValue(this._options, paramShort);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toXml(String paramString) {
/* 314 */     return paramString + "<" + getClass().getSimpleName() + ">\n" + paramString + "\t" + "<RecordId>0x" + HexDump.toHex(this._recordId) + "</RecordId>\n" + paramString + "\t" + "<Options>" + this._options + "</Options>\n" + paramString + "</" + getClass().getSimpleName() + ">\n";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String formatXmlRecordHeader(String paramString1, String paramString2, String paramString3, String paramString4) {
/* 321 */     return "<" + paramString1 + " recordId=\"0x" + paramString2 + "\" version=\"0x" + paramString3 + "\" instance=\"0x" + paramString4 + "\" size=\"" + getRecordSize() + "\">\n";
/*     */   }
/*     */ 
/*     */   
/*     */   public String toXml() {
/* 326 */     return toXml("");
/*     */   }
/*     */   
/*     */   public abstract int fillFields(byte[] paramArrayOfbyte, int paramInt, EscherRecordFactory paramEscherRecordFactory);
/*     */   
/*     */   public abstract int serialize(int paramInt, byte[] paramArrayOfbyte, EscherSerializationListener paramEscherSerializationListener);
/*     */   
/*     */   public abstract int getRecordSize();
/*     */   
/*     */   public abstract String getRecordName();
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ddf\EscherRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */