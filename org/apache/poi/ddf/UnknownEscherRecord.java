/*     */ package org.apache.poi.ddf;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import org.apache.poi.util.HexDump;
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
/*     */ public final class UnknownEscherRecord
/*     */   extends EscherRecord
/*     */   implements Cloneable
/*     */ {
/*  32 */   private static final byte[] NO_BYTES = new byte[0];
/*     */ 
/*     */   
/*  35 */   private byte[] thedata = NO_BYTES;
/*     */   private List<EscherRecord> _childRecords;
/*     */   
/*     */   public UnknownEscherRecord() {
/*  39 */     this._childRecords = new ArrayList<EscherRecord>();
/*     */   }
/*     */ 
/*     */   
/*     */   public int fillFields(byte[] paramArrayOfbyte, int paramInt, EscherRecordFactory paramEscherRecordFactory) {
/*  44 */     int i = readHeader(paramArrayOfbyte, paramInt);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  49 */     int j = paramArrayOfbyte.length - paramInt + 8;
/*  50 */     if (i > j) {
/*  51 */       i = j;
/*     */     }
/*     */     
/*  54 */     if (isContainerRecord()) {
/*  55 */       int k = 0;
/*  56 */       this.thedata = new byte[0];
/*  57 */       paramInt += 8;
/*  58 */       k += true;
/*  59 */       while (i > 0) {
/*     */         
/*  61 */         EscherRecord escherRecord = paramEscherRecordFactory.createRecord(paramArrayOfbyte, paramInt);
/*  62 */         int m = escherRecord.fillFields(paramArrayOfbyte, paramInt, paramEscherRecordFactory);
/*  63 */         k += m;
/*  64 */         paramInt += m;
/*  65 */         i -= m;
/*  66 */         getChildRecords().add(escherRecord);
/*     */       } 
/*  68 */       return k;
/*     */     } 
/*     */     
/*  71 */     this.thedata = new byte[i];
/*  72 */     System.arraycopy(paramArrayOfbyte, paramInt + 8, this.thedata, 0, i);
/*  73 */     return i + 8;
/*     */   }
/*     */ 
/*     */   
/*     */   public int serialize(int paramInt, byte[] paramArrayOfbyte, EscherSerializationListener paramEscherSerializationListener) {
/*  78 */     paramEscherSerializationListener.beforeRecordSerialize(paramInt, getRecordId(), this);
/*     */     
/*  80 */     LittleEndian.putShort(paramArrayOfbyte, paramInt, getOptions());
/*  81 */     LittleEndian.putShort(paramArrayOfbyte, paramInt + 2, getRecordId());
/*  82 */     int i = this.thedata.length;
/*  83 */     for (EscherRecord escherRecord : this._childRecords) {
/*  84 */       i += escherRecord.getRecordSize();
/*     */     }
/*  86 */     LittleEndian.putInt(paramArrayOfbyte, paramInt + 4, i);
/*  87 */     System.arraycopy(this.thedata, 0, paramArrayOfbyte, paramInt + 8, this.thedata.length);
/*  88 */     int j = paramInt + 8 + this.thedata.length;
/*  89 */     for (EscherRecord escherRecord : this._childRecords) {
/*  90 */       j += escherRecord.serialize(j, paramArrayOfbyte, paramEscherSerializationListener);
/*     */     }
/*     */     
/*  93 */     paramEscherSerializationListener.afterRecordSerialize(j, getRecordId(), j - paramInt, this);
/*  94 */     return j - paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public byte[] getData() {
/* 101 */     return this.thedata;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getRecordSize() {
/* 106 */     return 8 + this.thedata.length;
/*     */   }
/*     */ 
/*     */   
/*     */   public List<EscherRecord> getChildRecords() {
/* 111 */     return this._childRecords;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setChildRecords(List<EscherRecord> paramList) {
/* 116 */     this._childRecords = paramList;
/*     */   }
/*     */ 
/*     */   
/*     */   public UnknownEscherRecord clone() {
/* 121 */     UnknownEscherRecord unknownEscherRecord = new UnknownEscherRecord();
/* 122 */     unknownEscherRecord.thedata = (byte[])this.thedata.clone();
/* 123 */     unknownEscherRecord.setOptions(getOptions());
/* 124 */     unknownEscherRecord.setRecordId(getRecordId());
/* 125 */     return unknownEscherRecord;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getRecordName() {
/* 130 */     return "Unknown 0x" + HexDump.toHex(getRecordId());
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 135 */     StringBuffer stringBuffer = new StringBuffer();
/* 136 */     if (getChildRecords().size() > 0) {
/* 137 */       stringBuffer.append("  children: \n");
/* 138 */       for (EscherRecord escherRecord : this._childRecords) {
/* 139 */         stringBuffer.append(escherRecord.toString());
/* 140 */         stringBuffer.append('\n');
/*     */       } 
/*     */     } 
/*     */     
/* 144 */     String str = HexDump.toHex(this.thedata, 32);
/*     */     
/* 146 */     return getClass().getName() + ":" + '\n' + "  isContainer: " + isContainerRecord() + '\n' + "  version: 0x" + HexDump.toHex(getVersion()) + '\n' + "  instance: 0x" + HexDump.toHex(getInstance()) + '\n' + "  recordId: 0x" + HexDump.toHex(getRecordId()) + '\n' + "  numchildren: " + getChildRecords().size() + '\n' + str + stringBuffer.toString();
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
/*     */   public String toXml(String paramString) {
/* 158 */     String str = HexDump.toHex(this.thedata, 32);
/* 159 */     StringBuilder stringBuilder = new StringBuilder();
/* 160 */     stringBuilder.append(paramString).append(formatXmlRecordHeader(getClass().getSimpleName(), HexDump.toHex(getRecordId()), HexDump.toHex(getVersion()), HexDump.toHex(getInstance()))).append(paramString).append("\t").append("<IsContainer>").append(isContainerRecord()).append("</IsContainer>\n").append(paramString).append("\t").append("<Numchildren>").append(HexDump.toHex(this._childRecords.size())).append("</Numchildren>\n");
/*     */ 
/*     */     
/* 163 */     Iterator<EscherRecord> iterator = this._childRecords.iterator();
/* 164 */     while (iterator.hasNext()) {
/*     */       
/* 166 */       EscherRecord escherRecord = iterator.next();
/* 167 */       stringBuilder.append(escherRecord.toXml(paramString + "\t"));
/*     */     } 
/* 169 */     stringBuilder.append(str).append("\n");
/* 170 */     stringBuilder.append(paramString).append("</").append(getClass().getSimpleName()).append(">\n");
/* 171 */     return stringBuilder.toString();
/*     */   }
/*     */   
/*     */   public void addChildRecord(EscherRecord paramEscherRecord) {
/* 175 */     getChildRecords().add(paramEscherRecord);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ddf\UnknownEscherRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */