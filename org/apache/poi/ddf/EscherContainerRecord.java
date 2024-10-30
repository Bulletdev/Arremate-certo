/*     */ package org.apache.poi.ddf;
/*     */ 
/*     */ import java.io.PrintWriter;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import org.apache.poi.util.HexDump;
/*     */ import org.apache.poi.util.LittleEndian;
/*     */ import org.apache.poi.util.POILogFactory;
/*     */ import org.apache.poi.util.POILogger;
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
/*     */ public final class EscherContainerRecord
/*     */   extends EscherRecord
/*     */ {
/*     */   public static final short DGG_CONTAINER = -4096;
/*     */   public static final short BSTORE_CONTAINER = -4095;
/*     */   public static final short DG_CONTAINER = -4094;
/*     */   public static final short SPGR_CONTAINER = -4093;
/*     */   public static final short SP_CONTAINER = -4092;
/*     */   public static final short SOLVER_CONTAINER = -4091;
/*  42 */   private static final POILogger log = POILogFactory.getLogger(EscherContainerRecord.class);
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
/*     */   private int _remainingLength;
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
/*  68 */   private final List<EscherRecord> _childRecords = new ArrayList<EscherRecord>();
/*     */ 
/*     */   
/*     */   public int fillFields(byte[] paramArrayOfbyte, int paramInt, EscherRecordFactory paramEscherRecordFactory) {
/*  72 */     int i = readHeader(paramArrayOfbyte, paramInt);
/*  73 */     int j = 8;
/*  74 */     int k = paramInt + 8;
/*  75 */     while (i > 0 && k < paramArrayOfbyte.length) {
/*  76 */       EscherRecord escherRecord = paramEscherRecordFactory.createRecord(paramArrayOfbyte, k);
/*  77 */       int m = escherRecord.fillFields(paramArrayOfbyte, k, paramEscherRecordFactory);
/*  78 */       j += m;
/*  79 */       k += m;
/*  80 */       i -= m;
/*  81 */       addChildRecord(escherRecord);
/*  82 */       if (k >= paramArrayOfbyte.length && i > 0) {
/*  83 */         this._remainingLength = i;
/*  84 */         if (log.check(5)) {
/*  85 */           log.log(5, new Object[] { "Not enough Escher data: " + i + " bytes remaining but no space left" });
/*     */         }
/*     */       } 
/*     */     } 
/*  89 */     return j;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int serialize(int paramInt, byte[] paramArrayOfbyte, EscherSerializationListener paramEscherSerializationListener) {
/*  95 */     paramEscherSerializationListener.beforeRecordSerialize(paramInt, getRecordId(), this);
/*     */     
/*  97 */     LittleEndian.putShort(paramArrayOfbyte, paramInt, getOptions());
/*  98 */     LittleEndian.putShort(paramArrayOfbyte, paramInt + 2, getRecordId());
/*  99 */     int i = 0;
/* 100 */     Iterator<EscherRecord> iterator = this._childRecords.iterator();
/* 101 */     while (iterator.hasNext()) {
/* 102 */       EscherRecord escherRecord = iterator.next();
/* 103 */       i += escherRecord.getRecordSize();
/*     */     } 
/* 105 */     i += this._remainingLength;
/* 106 */     LittleEndian.putInt(paramArrayOfbyte, paramInt + 4, i);
/* 107 */     int j = paramInt + 8;
/* 108 */     iterator = this._childRecords.iterator();
/* 109 */     while (iterator.hasNext()) {
/* 110 */       EscherRecord escherRecord = iterator.next();
/* 111 */       j += escherRecord.serialize(j, paramArrayOfbyte, paramEscherSerializationListener);
/*     */     } 
/*     */     
/* 114 */     paramEscherSerializationListener.afterRecordSerialize(j, getRecordId(), j - paramInt, this);
/* 115 */     return j - paramInt;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getRecordSize() {
/* 120 */     int i = 0;
/* 121 */     Iterator<EscherRecord> iterator = this._childRecords.iterator();
/* 122 */     while (iterator.hasNext()) {
/* 123 */       EscherRecord escherRecord = iterator.next();
/* 124 */       i += escherRecord.getRecordSize();
/*     */     } 
/* 126 */     return 8 + i;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean hasChildOfType(short paramShort) {
/* 137 */     Iterator<EscherRecord> iterator = this._childRecords.iterator();
/* 138 */     while (iterator.hasNext()) {
/* 139 */       EscherRecord escherRecord = iterator.next();
/* 140 */       if (escherRecord.getRecordId() == paramShort) {
/* 141 */         return true;
/*     */       }
/*     */     } 
/* 144 */     return false;
/*     */   }
/*     */   
/*     */   public EscherRecord getChild(int paramInt) {
/* 148 */     return this._childRecords.get(paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<EscherRecord> getChildRecords() {
/* 156 */     return new ArrayList<EscherRecord>(this._childRecords);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Iterator<EscherRecord> getChildIterator() {
/* 163 */     return Collections.<EscherRecord>unmodifiableList(this._childRecords).iterator();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setChildRecords(List<EscherRecord> paramList) {
/* 171 */     if (paramList == this._childRecords) {
/* 172 */       throw new IllegalStateException("Child records private data member has escaped");
/*     */     }
/* 174 */     this._childRecords.clear();
/* 175 */     this._childRecords.addAll(paramList);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean removeChildRecord(EscherRecord paramEscherRecord) {
/* 185 */     return this._childRecords.remove(paramEscherRecord);
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
/*     */   public List<EscherContainerRecord> getChildContainers() {
/* 197 */     ArrayList<EscherContainerRecord> arrayList = new ArrayList();
/* 198 */     Iterator<EscherRecord> iterator = this._childRecords.iterator();
/* 199 */     while (iterator.hasNext()) {
/* 200 */       EscherRecord escherRecord = iterator.next();
/* 201 */       if (escherRecord instanceof EscherContainerRecord) {
/* 202 */         arrayList.add((EscherContainerRecord)escherRecord);
/*     */       }
/*     */     } 
/* 205 */     return arrayList;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getRecordName() {
/* 210 */     switch (getRecordId()) {
/*     */       case -4096:
/* 212 */         return "DggContainer";
/*     */       case -4095:
/* 214 */         return "BStoreContainer";
/*     */       case -4094:
/* 216 */         return "DgContainer";
/*     */       case -4093:
/* 218 */         return "SpgrContainer";
/*     */       case -4092:
/* 220 */         return "SpContainer";
/*     */       case -4091:
/* 222 */         return "SolverContainer";
/*     */     } 
/* 224 */     return "Container 0x" + HexDump.toHex(getRecordId());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void display(PrintWriter paramPrintWriter, int paramInt) {
/* 230 */     super.display(paramPrintWriter, paramInt);
/* 231 */     for (EscherRecord escherRecord : this._childRecords)
/*     */     {
/*     */       
/* 234 */       escherRecord.display(paramPrintWriter, paramInt + 1);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void addChildRecord(EscherRecord paramEscherRecord) {
/* 244 */     this._childRecords.add(paramEscherRecord);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void addChildBefore(EscherRecord paramEscherRecord, int paramInt) {
/* 254 */     byte b = 0;
/* 255 */     for (EscherRecord escherRecord : this._childRecords) {
/* 256 */       if (escherRecord.getRecordId() == (short)paramInt)
/*     */         break; 
/* 258 */       b++;
/*     */     } 
/* 260 */     this._childRecords.add(b, paramEscherRecord);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 266 */     String str = System.getProperty("line.separator");
/*     */     
/* 268 */     StringBuffer stringBuffer = new StringBuffer();
/* 269 */     if (this._childRecords.size() > 0) {
/*     */       
/* 271 */       stringBuffer.append("  children: " + str);
/*     */       
/* 273 */       byte b = 0;
/* 274 */       Iterator<EscherRecord> iterator = this._childRecords.iterator();
/* 275 */       while (iterator.hasNext()) {
/*     */         
/* 277 */         EscherRecord escherRecord = iterator.next();
/* 278 */         stringBuffer.append("   Child " + b + ":" + str);
/* 279 */         String str1 = String.valueOf(escherRecord);
/* 280 */         str1 = str1.replaceAll("\n", "\n    ");
/* 281 */         stringBuffer.append("    ");
/* 282 */         stringBuffer.append(str1);
/* 283 */         stringBuffer.append(str);
/* 284 */         b++;
/*     */       } 
/*     */     } 
/*     */     
/* 288 */     return getClass().getName() + " (" + getRecordName() + "):" + str + "  isContainer: " + isContainerRecord() + str + "  version: 0x" + HexDump.toHex(getVersion()) + str + "  instance: 0x" + HexDump.toHex(getInstance()) + str + "  recordId: 0x" + HexDump.toHex(getRecordId()) + str + "  numchildren: " + this._childRecords.size() + str + stringBuffer.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toXml(String paramString) {
/* 299 */     StringBuilder stringBuilder = new StringBuilder();
/* 300 */     stringBuilder.append(paramString).append(formatXmlRecordHeader(getRecordName(), HexDump.toHex(getRecordId()), HexDump.toHex(getVersion()), HexDump.toHex(getInstance())));
/* 301 */     Iterator<EscherRecord> iterator = this._childRecords.iterator();
/* 302 */     while (iterator.hasNext()) {
/*     */       
/* 304 */       EscherRecord escherRecord = iterator.next();
/* 305 */       stringBuilder.append(escherRecord.toXml(paramString + "\t"));
/*     */     } 
/* 307 */     stringBuilder.append(paramString).append("</").append(getRecordName()).append(">\n");
/* 308 */     return stringBuilder.toString();
/*     */   }
/*     */ 
/*     */   
/*     */   public <T extends EscherRecord> T getChildById(short paramShort) {
/* 313 */     for (EscherRecord escherRecord : this._childRecords) {
/*     */       
/* 315 */       if (escherRecord.getRecordId() == paramShort)
/*     */       {
/*     */         
/* 318 */         return (T)escherRecord;
/*     */       }
/*     */     } 
/*     */     
/* 322 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void getRecordsById(short paramShort, List<EscherRecord> paramList) {
/* 332 */     Iterator<EscherRecord> iterator = this._childRecords.iterator();
/* 333 */     while (iterator.hasNext()) {
/* 334 */       EscherRecord escherRecord = iterator.next();
/* 335 */       if (escherRecord instanceof EscherContainerRecord) {
/* 336 */         EscherContainerRecord escherContainerRecord = (EscherContainerRecord)escherRecord;
/* 337 */         escherContainerRecord.getRecordsById(paramShort, paramList); continue;
/* 338 */       }  if (escherRecord.getRecordId() == paramShort)
/* 339 */         paramList.add(escherRecord); 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ddf\EscherContainerRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */