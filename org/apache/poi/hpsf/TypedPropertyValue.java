/*     */ package org.apache.poi.hpsf;
/*     */ 
/*     */ import org.apache.poi.util.Internal;
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
/*     */ @Internal
/*     */ class TypedPropertyValue
/*     */ {
/*  29 */   private static final POILogger logger = POILogFactory.getLogger(TypedPropertyValue.class);
/*     */ 
/*     */   
/*     */   private int _type;
/*     */ 
/*     */   
/*     */   private Object _value;
/*     */ 
/*     */   
/*     */   TypedPropertyValue() {}
/*     */ 
/*     */   
/*     */   TypedPropertyValue(byte[] paramArrayOfbyte, int paramInt) {
/*  42 */     read(paramArrayOfbyte, paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   TypedPropertyValue(int paramInt, Object paramObject) {
/*  47 */     this._type = paramInt;
/*  48 */     this._value = paramObject;
/*     */   }
/*     */ 
/*     */   
/*     */   Object getValue() {
/*  53 */     return this._value;
/*     */   }
/*     */ 
/*     */   
/*     */   int read(byte[] paramArrayOfbyte, int paramInt) {
/*  58 */     int i = paramInt;
/*     */     
/*  60 */     this._type = LittleEndian.getShort(paramArrayOfbyte, i);
/*  61 */     i += 2;
/*     */     
/*  63 */     short s = LittleEndian.getShort(paramArrayOfbyte, i);
/*  64 */     i += 2;
/*  65 */     if (s != 0)
/*     */     {
/*  67 */       logger.log(5, new Object[] { "TypedPropertyValue padding at offset " + i + " MUST be 0, but it's value is " + s });
/*     */     }
/*     */ 
/*     */     
/*  71 */     i += readValue(paramArrayOfbyte, i);
/*     */     
/*  73 */     return i - paramInt;
/*     */   }
/*     */ 
/*     */   
/*     */   int readValue(byte[] paramArrayOfbyte, int paramInt) {
/*  78 */     switch (this._type) {
/*     */       
/*     */       case 0:
/*     */       case 1:
/*  82 */         this._value = null;
/*  83 */         return 0;
/*     */       
/*     */       case 2:
/*     */       case 4:
/*  87 */         this._value = Short.valueOf(LittleEndian.getShort(paramArrayOfbyte, paramInt));
/*  88 */         return 4;
/*     */       
/*     */       case 3:
/*     */       case 22:
/*  92 */         this._value = Integer.valueOf(LittleEndian.getInt(paramArrayOfbyte, paramInt));
/*  93 */         return 4;
/*     */       
/*     */       case 5:
/*  96 */         this._value = Double.valueOf(LittleEndian.getDouble(paramArrayOfbyte, paramInt));
/*  97 */         return 8;
/*     */       
/*     */       case 6:
/* 100 */         this._value = new Currency(paramArrayOfbyte, paramInt);
/* 101 */         return 8;
/*     */       
/*     */       case 7:
/* 104 */         this._value = new Date(paramArrayOfbyte, paramInt);
/* 105 */         return 8;
/*     */       
/*     */       case 8:
/* 108 */         this._value = new CodePageString(paramArrayOfbyte, paramInt);
/* 109 */         return ((CodePageString)this._value).getSize();
/*     */       
/*     */       case 11:
/* 112 */         this._value = new VariantBool(paramArrayOfbyte, paramInt);
/* 113 */         return 2;
/*     */       
/*     */       case 14:
/* 116 */         this._value = new Decimal(paramArrayOfbyte, paramInt);
/* 117 */         return 16;
/*     */       
/*     */       case 16:
/* 120 */         this._value = Byte.valueOf(paramArrayOfbyte[paramInt]);
/* 121 */         return 1;
/*     */       
/*     */       case 17:
/* 124 */         this._value = Short.valueOf(LittleEndian.getUByte(paramArrayOfbyte, paramInt));
/* 125 */         return 2;
/*     */       
/*     */       case 18:
/* 128 */         this._value = Integer.valueOf(LittleEndian.getUShort(paramArrayOfbyte, paramInt));
/* 129 */         return 4;
/*     */       
/*     */       case 10:
/*     */       case 19:
/*     */       case 23:
/* 134 */         this._value = Long.valueOf(LittleEndian.getUInt(paramArrayOfbyte, paramInt));
/* 135 */         return 4;
/*     */       
/*     */       case 20:
/* 138 */         this._value = Long.valueOf(LittleEndian.getLong(paramArrayOfbyte, paramInt));
/* 139 */         return 8;
/*     */       
/*     */       case 21:
/* 142 */         this._value = LittleEndian.getByteArray(paramArrayOfbyte, paramInt, 8);
/* 143 */         return 8;
/*     */       
/*     */       case 30:
/* 146 */         this._value = new CodePageString(paramArrayOfbyte, paramInt);
/* 147 */         return ((CodePageString)this._value).getSize();
/*     */       
/*     */       case 31:
/* 150 */         this._value = new UnicodeString(paramArrayOfbyte, paramInt);
/* 151 */         return ((UnicodeString)this._value).getSize();
/*     */       
/*     */       case 64:
/* 154 */         this._value = new Filetime(paramArrayOfbyte, paramInt);
/* 155 */         return 8;
/*     */       
/*     */       case 65:
/* 158 */         this._value = new Blob(paramArrayOfbyte, paramInt);
/* 159 */         return ((Blob)this._value).getSize();
/*     */       
/*     */       case 66:
/*     */       case 67:
/*     */       case 68:
/*     */       case 69:
/* 165 */         this._value = new IndirectPropertyName(paramArrayOfbyte, paramInt);
/* 166 */         return ((IndirectPropertyName)this._value).getSize();
/*     */       
/*     */       case 70:
/* 169 */         this._value = new Blob(paramArrayOfbyte, paramInt);
/* 170 */         return ((Blob)this._value).getSize();
/*     */       
/*     */       case 71:
/* 173 */         this._value = new ClipboardData(paramArrayOfbyte, paramInt);
/* 174 */         return ((ClipboardData)this._value).getSize();
/*     */       
/*     */       case 72:
/* 177 */         this._value = new GUID(paramArrayOfbyte, paramInt);
/* 178 */         return 16;
/*     */       
/*     */       case 73:
/* 181 */         this._value = new VersionedStream(paramArrayOfbyte, paramInt);
/* 182 */         return ((VersionedStream)this._value).getSize();
/*     */       
/*     */       case 4098:
/*     */       case 4099:
/*     */       case 4100:
/*     */       case 4101:
/*     */       case 4102:
/*     */       case 4103:
/*     */       case 4104:
/*     */       case 4106:
/*     */       case 4107:
/*     */       case 4108:
/*     */       case 4112:
/*     */       case 4113:
/*     */       case 4114:
/*     */       case 4115:
/*     */       case 4116:
/*     */       case 4117:
/*     */       case 4126:
/*     */       case 4127:
/*     */       case 4160:
/*     */       case 4167:
/*     */       case 4168:
/* 205 */         this._value = new Vector((short)(this._type & 0xFFF));
/* 206 */         return ((Vector)this._value).read(paramArrayOfbyte, paramInt);
/*     */       
/*     */       case 8194:
/*     */       case 8195:
/*     */       case 8196:
/*     */       case 8197:
/*     */       case 8198:
/*     */       case 8199:
/*     */       case 8200:
/*     */       case 8202:
/*     */       case 8203:
/*     */       case 8204:
/*     */       case 8206:
/*     */       case 8208:
/*     */       case 8209:
/*     */       case 8210:
/*     */       case 8211:
/*     */       case 8214:
/*     */       case 8215:
/* 225 */         this._value = new Array();
/* 226 */         return ((Array)this._value).read(paramArrayOfbyte, paramInt);
/*     */     } 
/*     */     
/* 229 */     throw new UnsupportedOperationException("Unknown (possibly, incorrect) TypedPropertyValue type: " + this._type);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   int readValuePadded(byte[] paramArrayOfbyte, int paramInt) {
/* 237 */     int i = readValue(paramArrayOfbyte, paramInt);
/* 238 */     return ((i & 0x3) == 0) ? i : (i + 4 - (i & 0x3));
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hpsf\TypedPropertyValue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */