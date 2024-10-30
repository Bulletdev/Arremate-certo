/*     */ package org.apache.poi.poifs.crypt;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.nio.charset.Charset;
/*     */ import org.apache.poi.EncryptedDocumentException;
/*     */ import org.apache.poi.poifs.crypt.standard.EncryptionRecord;
/*     */ import org.apache.poi.poifs.filesystem.DirectoryEntry;
/*     */ import org.apache.poi.poifs.filesystem.DocumentEntry;
/*     */ import org.apache.poi.poifs.filesystem.POIFSWriterEvent;
/*     */ import org.apache.poi.poifs.filesystem.POIFSWriterListener;
/*     */ import org.apache.poi.util.LittleEndianByteArrayOutputStream;
/*     */ import org.apache.poi.util.LittleEndianInput;
/*     */ import org.apache.poi.util.LittleEndianOutput;
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
/*     */ public class DataSpaceMapUtils
/*     */ {
/*     */   public static void addDefaultDataSpace(DirectoryEntry paramDirectoryEntry) throws IOException {
/*  37 */     DataSpaceMapEntry dataSpaceMapEntry = new DataSpaceMapEntry(new int[] { 0 }, new String[] { "EncryptedPackage" }, "StrongEncryptionDataSpace");
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  42 */     DataSpaceMap dataSpaceMap = new DataSpaceMap(new DataSpaceMapEntry[] { dataSpaceMapEntry });
/*  43 */     createEncryptionEntry(paramDirectoryEntry, "\006DataSpaces/DataSpaceMap", dataSpaceMap);
/*     */     
/*  45 */     DataSpaceDefinition dataSpaceDefinition = new DataSpaceDefinition(new String[] { "StrongEncryptionTransform" });
/*  46 */     createEncryptionEntry(paramDirectoryEntry, "\006DataSpaces/DataSpaceInfo/StrongEncryptionDataSpace", dataSpaceDefinition);
/*     */     
/*  48 */     TransformInfoHeader transformInfoHeader = new TransformInfoHeader(1, "{FF9A3F03-56EF-4613-BDD5-5A41C1D07246}", "Microsoft.Container.EncryptionTransform", 1, 0, 1, 0, 1, 0);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  54 */     IRMDSTransformInfo iRMDSTransformInfo = new IRMDSTransformInfo(transformInfoHeader, 0, null);
/*  55 */     createEncryptionEntry(paramDirectoryEntry, "\006DataSpaces/TransformInfo/StrongEncryptionTransform/\006Primary", iRMDSTransformInfo);
/*     */     
/*  57 */     DataSpaceVersionInfo dataSpaceVersionInfo = new DataSpaceVersionInfo("Microsoft.Container.DataSpaces", 1, 0, 1, 0, 1, 0);
/*  58 */     createEncryptionEntry(paramDirectoryEntry, "\006DataSpaces/Version", dataSpaceVersionInfo);
/*     */   }
/*     */   
/*     */   public static DocumentEntry createEncryptionEntry(DirectoryEntry paramDirectoryEntry, String paramString, EncryptionRecord paramEncryptionRecord) throws IOException {
/*  62 */     String[] arrayOfString = paramString.split("/");
/*  63 */     for (byte b = 0; b < arrayOfString.length - 1; b++) {
/*  64 */       paramDirectoryEntry = paramDirectoryEntry.hasEntry(arrayOfString[b]) ? (DirectoryEntry)paramDirectoryEntry.getEntry(arrayOfString[b]) : paramDirectoryEntry.createDirectory(arrayOfString[b]);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*  69 */     final byte[] buf = new byte[5000];
/*  70 */     LittleEndianByteArrayOutputStream littleEndianByteArrayOutputStream = new LittleEndianByteArrayOutputStream(arrayOfByte, 0);
/*  71 */     paramEncryptionRecord.write(littleEndianByteArrayOutputStream);
/*     */     
/*  73 */     String str = arrayOfString[arrayOfString.length - 1];
/*     */     
/*  75 */     if (paramDirectoryEntry.hasEntry(str)) {
/*  76 */       paramDirectoryEntry.getEntry(str).delete();
/*     */     }
/*     */     
/*  79 */     return paramDirectoryEntry.createDocument(str, littleEndianByteArrayOutputStream.getWriteIndex(), new POIFSWriterListener() {
/*     */           public void processPOIFSWriterEvent(POIFSWriterEvent param1POIFSWriterEvent) {
/*     */             try {
/*  82 */               param1POIFSWriterEvent.getStream().write(buf, 0, param1POIFSWriterEvent.getLimit());
/*  83 */             } catch (IOException iOException) {
/*  84 */               throw new EncryptedDocumentException(iOException);
/*     */             } 
/*     */           }
/*     */         });
/*     */   }
/*     */   
/*     */   public static class DataSpaceMap implements EncryptionRecord {
/*     */     DataSpaceMapUtils.DataSpaceMapEntry[] entries;
/*     */     
/*     */     public DataSpaceMap(DataSpaceMapUtils.DataSpaceMapEntry[] param1ArrayOfDataSpaceMapEntry) {
/*  94 */       this.entries = (DataSpaceMapUtils.DataSpaceMapEntry[])param1ArrayOfDataSpaceMapEntry.clone();
/*     */     }
/*     */     
/*     */     public DataSpaceMap(LittleEndianInput param1LittleEndianInput) {
/*  98 */       param1LittleEndianInput.readInt();
/*  99 */       int i = param1LittleEndianInput.readInt();
/* 100 */       this.entries = new DataSpaceMapUtils.DataSpaceMapEntry[i];
/* 101 */       for (byte b = 0; b < i; b++) {
/* 102 */         this.entries[b] = new DataSpaceMapUtils.DataSpaceMapEntry(param1LittleEndianInput);
/*     */       }
/*     */     }
/*     */     
/*     */     public void write(LittleEndianByteArrayOutputStream param1LittleEndianByteArrayOutputStream) {
/* 107 */       param1LittleEndianByteArrayOutputStream.writeInt(8);
/* 108 */       param1LittleEndianByteArrayOutputStream.writeInt(this.entries.length);
/* 109 */       for (DataSpaceMapUtils.DataSpaceMapEntry dataSpaceMapEntry : this.entries)
/* 110 */         dataSpaceMapEntry.write(param1LittleEndianByteArrayOutputStream); 
/*     */     }
/*     */   }
/*     */   
/*     */   public static class DataSpaceMapEntry
/*     */     implements EncryptionRecord {
/*     */     final int[] referenceComponentType;
/*     */     final String[] referenceComponent;
/*     */     final String dataSpaceName;
/*     */     
/*     */     public DataSpaceMapEntry(int[] param1ArrayOfint, String[] param1ArrayOfString, String param1String) {
/* 121 */       this.referenceComponentType = (int[])param1ArrayOfint.clone();
/* 122 */       this.referenceComponent = (String[])param1ArrayOfString.clone();
/* 123 */       this.dataSpaceName = param1String;
/*     */     }
/*     */     
/*     */     public DataSpaceMapEntry(LittleEndianInput param1LittleEndianInput) {
/* 127 */       param1LittleEndianInput.readInt();
/* 128 */       int i = param1LittleEndianInput.readInt();
/* 129 */       this.referenceComponentType = new int[i];
/* 130 */       this.referenceComponent = new String[i];
/* 131 */       for (byte b = 0; b < i; b++) {
/* 132 */         this.referenceComponentType[b] = param1LittleEndianInput.readInt();
/* 133 */         this.referenceComponent[b] = DataSpaceMapUtils.readUnicodeLPP4(param1LittleEndianInput);
/*     */       } 
/* 135 */       this.dataSpaceName = DataSpaceMapUtils.readUnicodeLPP4(param1LittleEndianInput);
/*     */     }
/*     */     
/*     */     public void write(LittleEndianByteArrayOutputStream param1LittleEndianByteArrayOutputStream) {
/* 139 */       int i = param1LittleEndianByteArrayOutputStream.getWriteIndex();
/* 140 */       LittleEndianOutput littleEndianOutput = param1LittleEndianByteArrayOutputStream.createDelayedOutput(4);
/* 141 */       param1LittleEndianByteArrayOutputStream.writeInt(this.referenceComponent.length);
/* 142 */       for (byte b = 0; b < this.referenceComponent.length; b++) {
/* 143 */         param1LittleEndianByteArrayOutputStream.writeInt(this.referenceComponentType[b]);
/* 144 */         DataSpaceMapUtils.writeUnicodeLPP4((LittleEndianOutput)param1LittleEndianByteArrayOutputStream, this.referenceComponent[b]);
/*     */       } 
/* 146 */       DataSpaceMapUtils.writeUnicodeLPP4((LittleEndianOutput)param1LittleEndianByteArrayOutputStream, this.dataSpaceName);
/* 147 */       littleEndianOutput.writeInt(param1LittleEndianByteArrayOutputStream.getWriteIndex() - i);
/*     */     }
/*     */   }
/*     */   
/*     */   public static class DataSpaceDefinition implements EncryptionRecord {
/*     */     String[] transformer;
/*     */     
/*     */     public DataSpaceDefinition(String[] param1ArrayOfString) {
/* 155 */       this.transformer = (String[])param1ArrayOfString.clone();
/*     */     }
/*     */     
/*     */     public DataSpaceDefinition(LittleEndianInput param1LittleEndianInput) {
/* 159 */       param1LittleEndianInput.readInt();
/* 160 */       int i = param1LittleEndianInput.readInt();
/* 161 */       this.transformer = new String[i];
/* 162 */       for (byte b = 0; b < i; b++) {
/* 163 */         this.transformer[b] = DataSpaceMapUtils.readUnicodeLPP4(param1LittleEndianInput);
/*     */       }
/*     */     }
/*     */     
/*     */     public void write(LittleEndianByteArrayOutputStream param1LittleEndianByteArrayOutputStream) {
/* 168 */       param1LittleEndianByteArrayOutputStream.writeInt(8);
/* 169 */       param1LittleEndianByteArrayOutputStream.writeInt(this.transformer.length);
/* 170 */       for (String str : this.transformer)
/* 171 */         DataSpaceMapUtils.writeUnicodeLPP4((LittleEndianOutput)param1LittleEndianByteArrayOutputStream, str); 
/*     */     }
/*     */   }
/*     */   
/*     */   public static class IRMDSTransformInfo
/*     */     implements EncryptionRecord {
/*     */     DataSpaceMapUtils.TransformInfoHeader transformInfoHeader;
/*     */     int extensibilityHeader;
/*     */     String xrMLLicense;
/*     */     
/*     */     public IRMDSTransformInfo(DataSpaceMapUtils.TransformInfoHeader param1TransformInfoHeader, int param1Int, String param1String) {
/* 182 */       this.transformInfoHeader = param1TransformInfoHeader;
/* 183 */       this.extensibilityHeader = param1Int;
/* 184 */       this.xrMLLicense = param1String;
/*     */     }
/*     */     
/*     */     public IRMDSTransformInfo(LittleEndianInput param1LittleEndianInput) {
/* 188 */       this.transformInfoHeader = new DataSpaceMapUtils.TransformInfoHeader(param1LittleEndianInput);
/* 189 */       this.extensibilityHeader = param1LittleEndianInput.readInt();
/* 190 */       this.xrMLLicense = DataSpaceMapUtils.readUtf8LPP4(param1LittleEndianInput);
/*     */     }
/*     */ 
/*     */     
/*     */     public void write(LittleEndianByteArrayOutputStream param1LittleEndianByteArrayOutputStream) {
/* 195 */       this.transformInfoHeader.write(param1LittleEndianByteArrayOutputStream);
/* 196 */       param1LittleEndianByteArrayOutputStream.writeInt(this.extensibilityHeader);
/* 197 */       DataSpaceMapUtils.writeUtf8LPP4((LittleEndianOutput)param1LittleEndianByteArrayOutputStream, this.xrMLLicense);
/* 198 */       param1LittleEndianByteArrayOutputStream.writeInt(4);
/*     */     }
/*     */   }
/*     */   
/*     */   public static class TransformInfoHeader implements EncryptionRecord {
/*     */     int transformType;
/*     */     String transformerId;
/*     */     String transformerName;
/* 206 */     int readerVersionMajor = 1, readerVersionMinor = 0;
/* 207 */     int updaterVersionMajor = 1, updaterVersionMinor = 0;
/* 208 */     int writerVersionMajor = 1, writerVersionMinor = 0;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public TransformInfoHeader(int param1Int1, String param1String1, String param1String2, int param1Int2, int param1Int3, int param1Int4, int param1Int5, int param1Int6, int param1Int7) {
/* 218 */       this.transformType = param1Int1;
/* 219 */       this.transformerId = param1String1;
/* 220 */       this.transformerName = param1String2;
/* 221 */       this.readerVersionMajor = param1Int2;
/* 222 */       this.readerVersionMinor = param1Int3;
/* 223 */       this.updaterVersionMajor = param1Int4;
/* 224 */       this.updaterVersionMinor = param1Int5;
/* 225 */       this.writerVersionMajor = param1Int6;
/* 226 */       this.writerVersionMinor = param1Int7;
/*     */     }
/*     */     
/*     */     public TransformInfoHeader(LittleEndianInput param1LittleEndianInput) {
/* 230 */       param1LittleEndianInput.readInt();
/* 231 */       this.transformType = param1LittleEndianInput.readInt();
/* 232 */       this.transformerId = DataSpaceMapUtils.readUnicodeLPP4(param1LittleEndianInput);
/* 233 */       this.transformerName = DataSpaceMapUtils.readUnicodeLPP4(param1LittleEndianInput);
/* 234 */       this.readerVersionMajor = param1LittleEndianInput.readShort();
/* 235 */       this.readerVersionMinor = param1LittleEndianInput.readShort();
/* 236 */       this.updaterVersionMajor = param1LittleEndianInput.readShort();
/* 237 */       this.updaterVersionMinor = param1LittleEndianInput.readShort();
/* 238 */       this.writerVersionMajor = param1LittleEndianInput.readShort();
/* 239 */       this.writerVersionMinor = param1LittleEndianInput.readShort();
/*     */     }
/*     */     
/*     */     public void write(LittleEndianByteArrayOutputStream param1LittleEndianByteArrayOutputStream) {
/* 243 */       int i = param1LittleEndianByteArrayOutputStream.getWriteIndex();
/* 244 */       LittleEndianOutput littleEndianOutput = param1LittleEndianByteArrayOutputStream.createDelayedOutput(4);
/* 245 */       param1LittleEndianByteArrayOutputStream.writeInt(this.transformType);
/* 246 */       DataSpaceMapUtils.writeUnicodeLPP4((LittleEndianOutput)param1LittleEndianByteArrayOutputStream, this.transformerId);
/* 247 */       littleEndianOutput.writeInt(param1LittleEndianByteArrayOutputStream.getWriteIndex() - i);
/* 248 */       DataSpaceMapUtils.writeUnicodeLPP4((LittleEndianOutput)param1LittleEndianByteArrayOutputStream, this.transformerName);
/* 249 */       param1LittleEndianByteArrayOutputStream.writeShort(this.readerVersionMajor);
/* 250 */       param1LittleEndianByteArrayOutputStream.writeShort(this.readerVersionMinor);
/* 251 */       param1LittleEndianByteArrayOutputStream.writeShort(this.updaterVersionMajor);
/* 252 */       param1LittleEndianByteArrayOutputStream.writeShort(this.updaterVersionMinor);
/* 253 */       param1LittleEndianByteArrayOutputStream.writeShort(this.writerVersionMajor);
/* 254 */       param1LittleEndianByteArrayOutputStream.writeShort(this.writerVersionMinor);
/*     */     }
/*     */   }
/*     */   
/*     */   public static class DataSpaceVersionInfo implements EncryptionRecord {
/*     */     String featureIdentifier;
/* 260 */     int readerVersionMajor = 1, readerVersionMinor = 0;
/* 261 */     int updaterVersionMajor = 1, updaterVersionMinor = 0;
/* 262 */     int writerVersionMajor = 1, writerVersionMinor = 0;
/*     */     
/*     */     public DataSpaceVersionInfo(LittleEndianInput param1LittleEndianInput) {
/* 265 */       this.featureIdentifier = DataSpaceMapUtils.readUnicodeLPP4(param1LittleEndianInput);
/* 266 */       this.readerVersionMajor = param1LittleEndianInput.readShort();
/* 267 */       this.readerVersionMinor = param1LittleEndianInput.readShort();
/* 268 */       this.updaterVersionMajor = param1LittleEndianInput.readShort();
/* 269 */       this.updaterVersionMinor = param1LittleEndianInput.readShort();
/* 270 */       this.writerVersionMajor = param1LittleEndianInput.readShort();
/* 271 */       this.writerVersionMinor = param1LittleEndianInput.readShort();
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public DataSpaceVersionInfo(String param1String, int param1Int1, int param1Int2, int param1Int3, int param1Int4, int param1Int5, int param1Int6) {
/* 280 */       this.featureIdentifier = param1String;
/* 281 */       this.readerVersionMajor = param1Int1;
/* 282 */       this.readerVersionMinor = param1Int2;
/* 283 */       this.updaterVersionMajor = param1Int3;
/* 284 */       this.updaterVersionMinor = param1Int4;
/* 285 */       this.writerVersionMajor = param1Int5;
/* 286 */       this.writerVersionMinor = param1Int6;
/*     */     }
/*     */     
/*     */     public void write(LittleEndianByteArrayOutputStream param1LittleEndianByteArrayOutputStream) {
/* 290 */       DataSpaceMapUtils.writeUnicodeLPP4((LittleEndianOutput)param1LittleEndianByteArrayOutputStream, this.featureIdentifier);
/* 291 */       param1LittleEndianByteArrayOutputStream.writeShort(this.readerVersionMajor);
/* 292 */       param1LittleEndianByteArrayOutputStream.writeShort(this.readerVersionMinor);
/* 293 */       param1LittleEndianByteArrayOutputStream.writeShort(this.updaterVersionMajor);
/* 294 */       param1LittleEndianByteArrayOutputStream.writeShort(this.updaterVersionMinor);
/* 295 */       param1LittleEndianByteArrayOutputStream.writeShort(this.writerVersionMajor);
/* 296 */       param1LittleEndianByteArrayOutputStream.writeShort(this.writerVersionMinor);
/*     */     }
/*     */   }
/*     */   
/*     */   public static String readUnicodeLPP4(LittleEndianInput paramLittleEndianInput) {
/* 301 */     int i = paramLittleEndianInput.readInt();
/* 302 */     if (i % 2 != 0) {
/* 303 */       throw new EncryptedDocumentException("UNICODE-LP-P4 structure is a multiple of 4 bytes. If Padding is present, it MUST be exactly 2 bytes long");
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 308 */     String str = StringUtil.readUnicodeLE(paramLittleEndianInput, i / 2);
/* 309 */     if (i % 4 == 2)
/*     */     {
/*     */ 
/*     */       
/* 313 */       paramLittleEndianInput.readShort();
/*     */     }
/*     */     
/* 316 */     return str;
/*     */   }
/*     */   
/*     */   public static void writeUnicodeLPP4(LittleEndianOutput paramLittleEndianOutput, String paramString) {
/* 320 */     byte[] arrayOfByte = StringUtil.getToUnicodeLE(paramString);
/* 321 */     paramLittleEndianOutput.writeInt(arrayOfByte.length);
/* 322 */     paramLittleEndianOutput.write(arrayOfByte);
/* 323 */     if (arrayOfByte.length % 4 == 2) {
/* 324 */       paramLittleEndianOutput.writeShort(0);
/*     */     }
/*     */   }
/*     */   
/*     */   public static String readUtf8LPP4(LittleEndianInput paramLittleEndianInput) {
/* 329 */     int i = paramLittleEndianInput.readInt();
/* 330 */     if (i == 0 || i == 4) {
/* 331 */       paramLittleEndianInput.readInt();
/* 332 */       return (i == 0) ? null : "";
/*     */     } 
/*     */     
/* 335 */     byte[] arrayOfByte = new byte[i];
/* 336 */     paramLittleEndianInput.readFully(arrayOfByte);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 343 */     int j = i % 4;
/* 344 */     if (j > 0) {
/* 345 */       for (byte b = 0; b < 4 - j; b++) {
/* 346 */         paramLittleEndianInput.readByte();
/*     */       }
/*     */     }
/*     */     
/* 350 */     return new String(arrayOfByte, 0, arrayOfByte.length, Charset.forName("UTF-8"));
/*     */   }
/*     */   
/*     */   public static void writeUtf8LPP4(LittleEndianOutput paramLittleEndianOutput, String paramString) {
/* 354 */     if (paramString == null || "".equals(paramString)) {
/* 355 */       paramLittleEndianOutput.writeInt((paramString == null) ? 0 : 4);
/* 356 */       paramLittleEndianOutput.writeInt(0);
/*     */     } else {
/* 358 */       byte[] arrayOfByte = paramString.getBytes(Charset.forName("UTF-8"));
/* 359 */       paramLittleEndianOutput.writeInt(arrayOfByte.length);
/* 360 */       paramLittleEndianOutput.write(arrayOfByte);
/* 361 */       int i = arrayOfByte.length % 4;
/* 362 */       if (i > 0)
/* 363 */         for (byte b = 0; b < 4 - i; b++)
/* 364 */           paramLittleEndianOutput.writeByte(0);  
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\poifs\crypt\DataSpaceMapUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */