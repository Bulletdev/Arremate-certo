/*     */ package org.apache.poi.hssf.record;
/*     */ 
/*     */ import org.apache.poi.EncryptedDocumentException;
/*     */ import org.apache.poi.util.HexDump;
/*     */ import org.apache.poi.util.LittleEndianOutput;
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
/*     */ public final class FilePassRecord
/*     */   extends StandardRecord
/*     */   implements Cloneable
/*     */ {
/*     */   public static final short sid = 47;
/*     */   private static final int ENCRYPTION_XOR = 0;
/*     */   private static final int ENCRYPTION_OTHER = 1;
/*     */   private int _encryptionType;
/*     */   private KeyData _keyData;
/*     */   
/*     */   private static interface KeyData
/*     */     extends Cloneable
/*     */   {
/*     */     void read(RecordInputStream param1RecordInputStream);
/*     */     
/*     */     void serialize(LittleEndianOutput param1LittleEndianOutput);
/*     */     
/*     */     int getDataSize();
/*     */     
/*     */     void appendToString(StringBuffer param1StringBuffer);
/*     */     
/*     */     KeyData clone();
/*     */   }
/*     */   
/*     */   public static final class Rc4KeyData
/*     */     implements Cloneable, KeyData
/*     */   {
/*     */     private static final int ENCRYPTION_OTHER_RC4 = 1;
/*     */     private static final int ENCRYPTION_OTHER_CAPI_2 = 2;
/*     */     private static final int ENCRYPTION_OTHER_CAPI_3 = 3;
/*     */     private static final int ENCRYPTION_OTHER_CAPI_4 = 4;
/*     */     private byte[] _salt;
/*     */     private byte[] _encryptedVerifier;
/*     */     private byte[] _encryptedVerifierHash;
/*     */     private int _encryptionInfo;
/*     */     private int _minorVersionNo;
/*     */     
/*     */     public void read(RecordInputStream param1RecordInputStream) {
/*  58 */       this._encryptionInfo = param1RecordInputStream.readUShort();
/*  59 */       switch (this._encryptionInfo) {
/*     */         case 1:
/*     */           break;
/*     */         
/*     */         case 2:
/*     */         case 3:
/*     */         case 4:
/*  66 */           throw new EncryptedDocumentException("HSSF does not currently support CryptoAPI encryption");
/*     */         
/*     */         default:
/*  69 */           throw new RecordFormatException("Unknown encryption info " + this._encryptionInfo);
/*     */       } 
/*  71 */       this._minorVersionNo = param1RecordInputStream.readUShort();
/*  72 */       if (this._minorVersionNo != 1) {
/*  73 */         throw new RecordFormatException("Unexpected VersionInfo number for RC4Header " + this._minorVersionNo);
/*     */       }
/*  75 */       this._salt = FilePassRecord.read(param1RecordInputStream, 16);
/*  76 */       this._encryptedVerifier = FilePassRecord.read(param1RecordInputStream, 16);
/*  77 */       this._encryptedVerifierHash = FilePassRecord.read(param1RecordInputStream, 16);
/*     */     }
/*     */     
/*     */     public void serialize(LittleEndianOutput param1LittleEndianOutput) {
/*  81 */       param1LittleEndianOutput.writeShort(this._encryptionInfo);
/*  82 */       param1LittleEndianOutput.writeShort(this._minorVersionNo);
/*  83 */       param1LittleEndianOutput.write(this._salt);
/*  84 */       param1LittleEndianOutput.write(this._encryptedVerifier);
/*  85 */       param1LittleEndianOutput.write(this._encryptedVerifierHash);
/*     */     }
/*     */     
/*     */     public int getDataSize() {
/*  89 */       return 54;
/*     */     }
/*     */     
/*     */     public byte[] getSalt() {
/*  93 */       return (byte[])this._salt.clone();
/*     */     }
/*     */     
/*     */     public void setSalt(byte[] param1ArrayOfbyte) {
/*  97 */       this._salt = (byte[])param1ArrayOfbyte.clone();
/*     */     }
/*     */     
/*     */     public byte[] getEncryptedVerifier() {
/* 101 */       return (byte[])this._encryptedVerifier.clone();
/*     */     }
/*     */     
/*     */     public void setEncryptedVerifier(byte[] param1ArrayOfbyte) {
/* 105 */       this._encryptedVerifier = (byte[])param1ArrayOfbyte.clone();
/*     */     }
/*     */     
/*     */     public byte[] getEncryptedVerifierHash() {
/* 109 */       return (byte[])this._encryptedVerifierHash.clone();
/*     */     }
/*     */     
/*     */     public void setEncryptedVerifierHash(byte[] param1ArrayOfbyte) {
/* 113 */       this._encryptedVerifierHash = (byte[])param1ArrayOfbyte.clone();
/*     */     }
/*     */     
/*     */     public void appendToString(StringBuffer param1StringBuffer) {
/* 117 */       param1StringBuffer.append("    .rc4.info = ").append(HexDump.shortToHex(this._encryptionInfo)).append("\n");
/* 118 */       param1StringBuffer.append("    .rc4.ver  = ").append(HexDump.shortToHex(this._minorVersionNo)).append("\n");
/* 119 */       param1StringBuffer.append("    .rc4.salt = ").append(HexDump.toHex(this._salt)).append("\n");
/* 120 */       param1StringBuffer.append("    .rc4.verifier = ").append(HexDump.toHex(this._encryptedVerifier)).append("\n");
/* 121 */       param1StringBuffer.append("    .rc4.verifierHash = ").append(HexDump.toHex(this._encryptedVerifierHash)).append("\n");
/*     */     }
/*     */ 
/*     */     
/*     */     public Rc4KeyData clone() {
/* 126 */       Rc4KeyData rc4KeyData = new Rc4KeyData();
/* 127 */       rc4KeyData._salt = (byte[])this._salt.clone();
/* 128 */       rc4KeyData._encryptedVerifier = (byte[])this._encryptedVerifier.clone();
/* 129 */       rc4KeyData._encryptedVerifierHash = (byte[])this._encryptedVerifierHash.clone();
/* 130 */       rc4KeyData._encryptionInfo = this._encryptionInfo;
/* 131 */       rc4KeyData._minorVersionNo = this._minorVersionNo;
/* 132 */       return rc4KeyData;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final class XorKeyData
/*     */     implements Cloneable, KeyData
/*     */   {
/*     */     private int _key;
/*     */ 
/*     */ 
/*     */     
/*     */     private int _verifier;
/*     */ 
/*     */ 
/*     */     
/*     */     public void read(RecordInputStream param1RecordInputStream) {
/* 151 */       this._key = param1RecordInputStream.readUShort();
/* 152 */       this._verifier = param1RecordInputStream.readUShort();
/*     */     }
/*     */     
/*     */     public void serialize(LittleEndianOutput param1LittleEndianOutput) {
/* 156 */       param1LittleEndianOutput.writeShort(this._key);
/* 157 */       param1LittleEndianOutput.writeShort(this._verifier);
/*     */     }
/*     */ 
/*     */     
/*     */     public int getDataSize() {
/* 162 */       return 6;
/*     */     }
/*     */     
/*     */     public int getKey() {
/* 166 */       return this._key;
/*     */     }
/*     */     
/*     */     public int getVerifier() {
/* 170 */       return this._verifier;
/*     */     }
/*     */     
/*     */     public void setKey(int param1Int) {
/* 174 */       this._key = param1Int;
/*     */     }
/*     */     
/*     */     public void setVerifier(int param1Int) {
/* 178 */       this._verifier = param1Int;
/*     */     }
/*     */     
/*     */     public void appendToString(StringBuffer param1StringBuffer) {
/* 182 */       param1StringBuffer.append("    .xor.key = ").append(HexDump.intToHex(this._key)).append("\n");
/* 183 */       param1StringBuffer.append("    .xor.verifier  = ").append(HexDump.intToHex(this._verifier)).append("\n");
/*     */     }
/*     */ 
/*     */     
/*     */     public XorKeyData clone() {
/* 188 */       XorKeyData xorKeyData = new XorKeyData();
/* 189 */       xorKeyData._key = this._key;
/* 190 */       xorKeyData._verifier = this._verifier;
/* 191 */       return xorKeyData;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private FilePassRecord(FilePassRecord paramFilePassRecord) {
/* 197 */     this._encryptionType = paramFilePassRecord._encryptionType;
/* 198 */     this._keyData = paramFilePassRecord._keyData.clone();
/*     */   }
/*     */   
/*     */   public FilePassRecord(RecordInputStream paramRecordInputStream) {
/* 202 */     this._encryptionType = paramRecordInputStream.readUShort();
/*     */     
/* 204 */     switch (this._encryptionType) {
/*     */       case 0:
/* 206 */         this._keyData = new XorKeyData();
/*     */         break;
/*     */       case 1:
/* 209 */         this._keyData = new Rc4KeyData();
/*     */         break;
/*     */       default:
/* 212 */         throw new RecordFormatException("Unknown encryption type " + this._encryptionType);
/*     */     } 
/*     */     
/* 215 */     this._keyData.read(paramRecordInputStream);
/*     */   }
/*     */   
/*     */   private static byte[] read(RecordInputStream paramRecordInputStream, int paramInt) {
/* 219 */     byte[] arrayOfByte = new byte[paramInt];
/* 220 */     paramRecordInputStream.readFully(arrayOfByte);
/* 221 */     return arrayOfByte;
/*     */   }
/*     */   
/*     */   public void serialize(LittleEndianOutput paramLittleEndianOutput) {
/* 225 */     paramLittleEndianOutput.writeShort(this._encryptionType);
/* 226 */     assert this._keyData != null;
/* 227 */     this._keyData.serialize(paramLittleEndianOutput);
/*     */   }
/*     */   
/*     */   protected int getDataSize() {
/* 231 */     assert this._keyData != null;
/* 232 */     return this._keyData.getDataSize();
/*     */   }
/*     */   
/*     */   public Rc4KeyData getRc4KeyData() {
/* 236 */     return (this._keyData instanceof Rc4KeyData) ? (Rc4KeyData)this._keyData : null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public XorKeyData getXorKeyData() {
/* 242 */     return (this._keyData instanceof XorKeyData) ? (XorKeyData)this._keyData : null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private Rc4KeyData checkRc4() {
/* 248 */     Rc4KeyData rc4KeyData = getRc4KeyData();
/* 249 */     if (rc4KeyData == null) {
/* 250 */       throw new RecordFormatException("file pass record doesn't contain a rc4 key.");
/*     */     }
/* 252 */     return rc4KeyData;
/*     */   }
/*     */   
/*     */   public short getSid() {
/* 256 */     return 47;
/*     */   }
/*     */ 
/*     */   
/*     */   public FilePassRecord clone() {
/* 261 */     return new FilePassRecord(this);
/*     */   }
/*     */   
/*     */   public String toString() {
/* 265 */     StringBuffer stringBuffer = new StringBuffer();
/*     */     
/* 267 */     stringBuffer.append("[FILEPASS]\n");
/* 268 */     stringBuffer.append("    .type = ").append(HexDump.shortToHex(this._encryptionType)).append("\n");
/* 269 */     this._keyData.appendToString(stringBuffer);
/* 270 */     stringBuffer.append("[/FILEPASS]\n");
/* 271 */     return stringBuffer.toString();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\FilePassRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */