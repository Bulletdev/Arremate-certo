/*     */ package com.sun.jna.platform.win32;
/*     */ 
/*     */ import com.sun.jna.Pointer;
/*     */ import com.sun.jna.PointerType;
/*     */ import com.sun.jna.Structure;
/*     */ import com.sun.jna.Structure.FieldOrder;
/*     */ import java.security.SecureRandom;
/*     */ import java.util.Arrays;
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
/*     */ public interface Guid
/*     */ {
/*  42 */   public static final IID IID_NULL = new IID();
/*     */   
/*     */   @FieldOrder({"Data1", "Data2", "Data3", "Data4"})
/*     */   public static class GUID
/*     */     extends Structure
/*     */   {
/*     */     public int Data1;
/*     */     public short Data2;
/*     */     public short Data3;
/*     */     
/*     */     public static class ByValue
/*     */       extends GUID
/*     */       implements Structure.ByValue {
/*     */       public ByValue() {}
/*     */       
/*     */       public ByValue(Guid.GUID param2GUID) {
/*  58 */         super(param2GUID.getPointer());
/*     */         
/*  60 */         this.Data1 = param2GUID.Data1;
/*  61 */         this.Data2 = param2GUID.Data2;
/*  62 */         this.Data3 = param2GUID.Data3;
/*  63 */         this.Data4 = param2GUID.Data4;
/*     */       }
/*     */       public ByValue(Pointer param2Pointer) {
/*  66 */         super(param2Pointer);
/*     */       }
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public static class ByReference
/*     */       extends GUID
/*     */       implements Structure.ByReference
/*     */     {
/*     */       public ByReference() {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public ByReference(Guid.GUID param2GUID) {
/*  91 */         super(param2GUID.getPointer());
/*     */         
/*  93 */         this.Data1 = param2GUID.Data1;
/*  94 */         this.Data2 = param2GUID.Data2;
/*  95 */         this.Data3 = param2GUID.Data3;
/*  96 */         this.Data4 = param2GUID.Data4;
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public ByReference(Pointer param2Pointer) {
/* 106 */         super(param2Pointer);
/*     */       }
/*     */     }
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
/* 120 */     public byte[] Data4 = new byte[8];
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public GUID() {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public GUID(GUID param1GUID) {
/* 135 */       this.Data1 = param1GUID.Data1;
/* 136 */       this.Data2 = param1GUID.Data2;
/* 137 */       this.Data3 = param1GUID.Data3;
/* 138 */       this.Data4 = param1GUID.Data4;
/*     */       
/* 140 */       writeFieldsToMemory();
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public GUID(String param1String) {
/* 150 */       this(fromString(param1String));
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public GUID(byte[] param1ArrayOfbyte) {
/* 160 */       this(fromBinary(param1ArrayOfbyte));
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public GUID(Pointer param1Pointer) {
/* 170 */       super(param1Pointer);
/* 171 */       read();
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean equals(Object param1Object) {
/* 176 */       if (param1Object == null) {
/* 177 */         return false;
/*     */       }
/* 179 */       if (this == param1Object) {
/* 180 */         return true;
/*     */       }
/* 182 */       if (getClass() != param1Object.getClass()) {
/* 183 */         return false;
/*     */       }
/*     */       
/* 186 */       GUID gUID = (GUID)param1Object;
/* 187 */       return (this.Data1 == gUID.Data1 && this.Data2 == gUID.Data2 && this.Data3 == gUID.Data3 && 
/*     */ 
/*     */         
/* 190 */         Arrays.equals(this.Data4, gUID.Data4));
/*     */     }
/*     */ 
/*     */     
/*     */     public int hashCode() {
/* 195 */       return this.Data1 + this.Data2 & 65535 + this.Data3 & 65535 + Arrays.hashCode(this.Data4);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public static GUID fromBinary(byte[] param1ArrayOfbyte) {
/* 206 */       if (param1ArrayOfbyte.length != 16) {
/* 207 */         throw new IllegalArgumentException("Invalid data length: " + param1ArrayOfbyte.length);
/*     */       }
/*     */ 
/*     */       
/* 211 */       GUID gUID = new GUID();
/* 212 */       long l = (param1ArrayOfbyte[0] & 0xFF);
/* 213 */       l <<= 8L;
/* 214 */       l |= (param1ArrayOfbyte[1] & 0xFF);
/* 215 */       l <<= 8L;
/* 216 */       l |= (param1ArrayOfbyte[2] & 0xFF);
/* 217 */       l <<= 8L;
/* 218 */       l |= (param1ArrayOfbyte[3] & 0xFF);
/* 219 */       gUID.Data1 = (int)l;
/*     */       
/* 221 */       int i = param1ArrayOfbyte[4] & 0xFF;
/* 222 */       i <<= 8;
/* 223 */       i |= param1ArrayOfbyte[5] & 0xFF;
/* 224 */       gUID.Data2 = (short)i;
/*     */       
/* 226 */       int j = param1ArrayOfbyte[6] & 0xFF;
/* 227 */       j <<= 8;
/* 228 */       j |= param1ArrayOfbyte[7] & 0xFF;
/* 229 */       gUID.Data3 = (short)j;
/*     */       
/* 231 */       gUID.Data4[0] = param1ArrayOfbyte[8];
/* 232 */       gUID.Data4[1] = param1ArrayOfbyte[9];
/* 233 */       gUID.Data4[2] = param1ArrayOfbyte[10];
/* 234 */       gUID.Data4[3] = param1ArrayOfbyte[11];
/* 235 */       gUID.Data4[4] = param1ArrayOfbyte[12];
/* 236 */       gUID.Data4[5] = param1ArrayOfbyte[13];
/* 237 */       gUID.Data4[6] = param1ArrayOfbyte[14];
/* 238 */       gUID.Data4[7] = param1ArrayOfbyte[15];
/*     */       
/* 240 */       gUID.writeFieldsToMemory();
/*     */       
/* 242 */       return gUID;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public static GUID fromString(String param1String) {
/* 253 */       byte b1 = 0;
/* 254 */       char[] arrayOfChar1 = new char[32];
/* 255 */       char[] arrayOfChar2 = param1String.toCharArray();
/* 256 */       byte[] arrayOfByte = new byte[16];
/* 257 */       GUID gUID = new GUID();
/*     */ 
/*     */       
/* 260 */       if (param1String.length() > 38) {
/* 261 */         throw new IllegalArgumentException("Invalid guid length: " + param1String
/* 262 */             .length());
/*     */       }
/*     */       
/*     */       byte b2;
/* 266 */       for (b2 = 0; b2 < arrayOfChar2.length; b2++) {
/* 267 */         if (arrayOfChar2[b2] != '{' && arrayOfChar2[b2] != '-' && arrayOfChar2[b2] != '}')
/*     */         {
/* 269 */           arrayOfChar1[b1++] = arrayOfChar2[b2];
/*     */         }
/*     */       } 
/*     */       
/* 273 */       for (b2 = 0; b2 < 32; b2 += 2) {
/* 274 */         arrayOfByte[b2 / 2] = 
/* 275 */           (byte)((Character.digit(arrayOfChar1[b2], 16) << 4) + Character.digit(arrayOfChar1[b2 + 1], 16) & 0xFF);
/*     */       }
/*     */       
/* 278 */       if (arrayOfByte.length != 16) {
/* 279 */         throw new IllegalArgumentException("Invalid data length: " + arrayOfByte.length);
/*     */       }
/*     */ 
/*     */       
/* 283 */       long l = (arrayOfByte[0] & 0xFF);
/* 284 */       l <<= 8L;
/* 285 */       l |= (arrayOfByte[1] & 0xFF);
/* 286 */       l <<= 8L;
/* 287 */       l |= (arrayOfByte[2] & 0xFF);
/* 288 */       l <<= 8L;
/* 289 */       l |= (arrayOfByte[3] & 0xFF);
/* 290 */       gUID.Data1 = (int)l;
/*     */       
/* 292 */       int i = arrayOfByte[4] & 0xFF;
/* 293 */       i <<= 8;
/* 294 */       i |= arrayOfByte[5] & 0xFF;
/* 295 */       gUID.Data2 = (short)i;
/*     */       
/* 297 */       int j = arrayOfByte[6] & 0xFF;
/* 298 */       j <<= 8;
/* 299 */       j |= arrayOfByte[7] & 0xFF;
/* 300 */       gUID.Data3 = (short)j;
/*     */       
/* 302 */       gUID.Data4[0] = arrayOfByte[8];
/* 303 */       gUID.Data4[1] = arrayOfByte[9];
/* 304 */       gUID.Data4[2] = arrayOfByte[10];
/* 305 */       gUID.Data4[3] = arrayOfByte[11];
/* 306 */       gUID.Data4[4] = arrayOfByte[12];
/* 307 */       gUID.Data4[5] = arrayOfByte[13];
/* 308 */       gUID.Data4[6] = arrayOfByte[14];
/* 309 */       gUID.Data4[7] = arrayOfByte[15];
/*     */       
/* 311 */       gUID.writeFieldsToMemory();
/*     */       
/* 313 */       return gUID;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public static GUID newGuid() {
/* 323 */       SecureRandom secureRandom = new SecureRandom();
/* 324 */       byte[] arrayOfByte = new byte[16];
/*     */       
/* 326 */       secureRandom.nextBytes(arrayOfByte);
/* 327 */       arrayOfByte[6] = (byte)(arrayOfByte[6] & 0xF);
/* 328 */       arrayOfByte[6] = (byte)(arrayOfByte[6] | 0x40);
/* 329 */       arrayOfByte[8] = (byte)(arrayOfByte[8] & 0x3F);
/* 330 */       arrayOfByte[8] = (byte)(arrayOfByte[8] | 0x80);
/*     */       
/* 332 */       return new GUID(arrayOfByte);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public byte[] toByteArray() {
/* 341 */       byte[] arrayOfByte1 = new byte[16];
/*     */       
/* 343 */       byte[] arrayOfByte2 = new byte[4];
/* 344 */       arrayOfByte2[0] = (byte)(this.Data1 >> 24);
/* 345 */       arrayOfByte2[1] = (byte)(this.Data1 >> 16);
/* 346 */       arrayOfByte2[2] = (byte)(this.Data1 >> 8);
/* 347 */       arrayOfByte2[3] = (byte)(this.Data1 >> 0);
/*     */       
/* 349 */       byte[] arrayOfByte3 = new byte[4];
/* 350 */       arrayOfByte3[0] = (byte)(this.Data2 >> 24);
/* 351 */       arrayOfByte3[1] = (byte)(this.Data2 >> 16);
/* 352 */       arrayOfByte3[2] = (byte)(this.Data2 >> 8);
/* 353 */       arrayOfByte3[3] = (byte)(this.Data2 >> 0);
/*     */       
/* 355 */       byte[] arrayOfByte4 = new byte[4];
/* 356 */       arrayOfByte4[0] = (byte)(this.Data3 >> 24);
/* 357 */       arrayOfByte4[1] = (byte)(this.Data3 >> 16);
/* 358 */       arrayOfByte4[2] = (byte)(this.Data3 >> 8);
/* 359 */       arrayOfByte4[3] = (byte)(this.Data3 >> 0);
/*     */       
/* 361 */       System.arraycopy(arrayOfByte2, 0, arrayOfByte1, 0, 4);
/* 362 */       System.arraycopy(arrayOfByte3, 2, arrayOfByte1, 4, 2);
/* 363 */       System.arraycopy(arrayOfByte4, 2, arrayOfByte1, 6, 2);
/* 364 */       System.arraycopy(this.Data4, 0, arrayOfByte1, 8, 8);
/*     */       
/* 366 */       return arrayOfByte1;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public String toGuidString() {
/* 376 */       String str = "0123456789ABCDEF";
/* 377 */       byte[] arrayOfByte = toByteArray();
/*     */       
/* 379 */       StringBuilder stringBuilder = new StringBuilder(2 * arrayOfByte.length);
/* 380 */       stringBuilder.append("{");
/*     */       
/* 382 */       for (byte b = 0; b < arrayOfByte.length; b++) {
/* 383 */         char c1 = "0123456789ABCDEF".charAt((arrayOfByte[b] & 0xF0) >> 4);
/* 384 */         char c2 = "0123456789ABCDEF".charAt(arrayOfByte[b] & 0xF);
/* 385 */         stringBuilder.append(c1).append(c2);
/*     */         
/* 387 */         if (b == 3 || b == 5 || b == 7 || b == 9) {
/* 388 */           stringBuilder.append("-");
/*     */         }
/*     */       } 
/* 391 */       stringBuilder.append("}");
/* 392 */       return stringBuilder.toString();
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected void writeFieldsToMemory() {
/* 399 */       for (String str : getFieldOrder()) {
/* 400 */         writeField(str);
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
/*     */   public static class CLSID
/*     */     extends GUID
/*     */   {
/*     */     public static class ByReference
/*     */       extends Guid.GUID
/*     */     {
/*     */       public ByReference() {}
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
/*     */       public ByReference(Guid.GUID param2GUID) {
/* 433 */         super(param2GUID);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public ByReference(Pointer param2Pointer) {
/* 443 */         super(param2Pointer);
/*     */       }
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public CLSID() {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public CLSID(String param1String) {
/* 460 */       super(param1String);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public CLSID(Guid.GUID param1GUID) {
/* 469 */       super(param1GUID);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static class REFIID
/*     */     extends PointerType
/*     */   {
/*     */     public REFIID() {}
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
/*     */     public REFIID(Pointer param1Pointer) {
/* 515 */       super(param1Pointer);
/*     */     }
/*     */     
/*     */     public REFIID(Guid.IID param1IID) {
/* 519 */       super(param1IID.getPointer());
/*     */     }
/*     */     
/*     */     public void setValue(Guid.IID param1IID) {
/* 523 */       setPointer(param1IID.getPointer());
/*     */     }
/*     */     
/*     */     public Guid.IID getValue() {
/* 527 */       return new Guid.IID(getPointer());
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean equals(Object param1Object) {
/* 532 */       if (param1Object == null) {
/* 533 */         return false;
/*     */       }
/* 535 */       if (this == param1Object) {
/* 536 */         return true;
/*     */       }
/* 538 */       if (getClass() != param1Object.getClass()) {
/* 539 */         return false;
/*     */       }
/*     */       
/* 542 */       REFIID rEFIID = (REFIID)param1Object;
/* 543 */       return getValue().equals(rEFIID.getValue());
/*     */     }
/*     */ 
/*     */     
/*     */     public int hashCode() {
/* 548 */       return getValue().hashCode();
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
/*     */   public static class IID
/*     */     extends GUID
/*     */   {
/*     */     public IID() {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public IID(Pointer param1Pointer) {
/* 573 */       super(param1Pointer);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public IID(String param1String) {
/* 582 */       super(param1String);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public IID(byte[] param1ArrayOfbyte) {
/* 592 */       super(param1ArrayOfbyte);
/*     */     }
/*     */     
/*     */     public IID(Guid.GUID param1GUID) {
/* 596 */       this(param1GUID.toGuidString());
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\sun\jna\platform\win32\Guid.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */