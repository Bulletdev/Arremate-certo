/*      */ package com.sun.jna.platform.win32;
/*      */ 
/*      */ import com.sun.jna.Memory;
/*      */ import com.sun.jna.Pointer;
/*      */ import com.sun.jna.StringArray;
/*      */ import com.sun.jna.Structure;
/*      */ import com.sun.jna.Structure.FieldOrder;
/*      */ import com.sun.jna.Union;
/*      */ import com.sun.jna.win32.W32APITypeMapper;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public interface Winevt
/*      */ {
/*      */   public static final int EVT_VARIANT_TYPE_ARRAY = 128;
/*      */   public static final int EVT_VARIANT_TYPE_MASK = 127;
/*      */   public static final int EVT_READ_ACCESS = 1;
/*      */   public static final int EVT_WRITE_ACCESS = 2;
/*      */   public static final int EVT_ALL_ACCESS = 7;
/*      */   public static final int EVT_CLEAR_ACCESS = 4;
/*      */   
/*      */   public enum EVT_VARIANT_TYPE
/*      */   {
/*   50 */     EvtVarTypeNull(""),
/*      */ 
/*      */     
/*   53 */     EvtVarTypeString("String"),
/*      */ 
/*      */     
/*   56 */     EvtVarTypeAnsiString("AnsiString"),
/*      */ 
/*      */     
/*   59 */     EvtVarTypeSByte("SByte"),
/*      */ 
/*      */     
/*   62 */     EvtVarTypeByte("Byte"),
/*      */ 
/*      */     
/*   65 */     EvtVarTypeInt16("Int16"),
/*      */ 
/*      */     
/*   68 */     EvtVarTypeUInt16("UInt16"),
/*      */ 
/*      */     
/*   71 */     EvtVarTypeInt32("Int32"),
/*      */ 
/*      */     
/*   74 */     EvtVarTypeUInt32("UInt32"),
/*      */ 
/*      */     
/*   77 */     EvtVarTypeInt64("Int64"),
/*      */ 
/*      */     
/*   80 */     EvtVarTypeUInt64("UInt64"),
/*      */ 
/*      */     
/*   83 */     EvtVarTypeSingle("Single"),
/*      */ 
/*      */     
/*   86 */     EvtVarTypeDouble("Double"),
/*      */ 
/*      */     
/*   89 */     EvtVarTypeBoolean("Boolean"),
/*      */ 
/*      */     
/*   92 */     EvtVarTypeBinary("Binary"),
/*      */ 
/*      */     
/*   95 */     EvtVarTypeGuid("Guid"),
/*      */ 
/*      */     
/*   98 */     EvtVarTypeSizeT("SizeT"),
/*      */ 
/*      */     
/*  101 */     EvtVarTypeFileTime("FileTime"),
/*      */ 
/*      */     
/*  104 */     EvtVarTypeSysTime("SysTime"),
/*      */ 
/*      */     
/*  107 */     EvtVarTypeSid("Sid"),
/*      */ 
/*      */     
/*  110 */     EvtVarTypeHexInt32("Int32"),
/*      */ 
/*      */     
/*  113 */     EvtVarTypeHexInt64("Int64"),
/*      */ 
/*      */     
/*  116 */     EvtVarTypeEvtHandle("EvtHandle"),
/*      */ 
/*      */     
/*  119 */     EvtVarTypeEvtXml("Xml");
/*      */     
/*      */     private final String field;
/*      */     
/*      */     EVT_VARIANT_TYPE(String param1String1) {
/*  124 */       this.field = param1String1;
/*      */     }
/*      */     
/*      */     public String getField() {
/*  128 */       return this.field.isEmpty() ? "" : (this.field + "Val");
/*      */     }
/*      */     
/*      */     public String getArrField() {
/*  132 */       return this.field.isEmpty() ? "" : (this.field + "Arr");
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @FieldOrder({"field1", "Count", "Type"})
/*      */   public static class EVT_VARIANT
/*      */     extends Structure
/*      */   {
/*      */     public field1_union field1;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public int Count;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public int Type;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private Object holder;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static class field1_union
/*      */       extends Union
/*      */     {
/*      */       public byte byteValue;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public short shortValue;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public int intValue;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public long longValue;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public float floatValue;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public double doubleVal;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public Pointer pointerValue;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public EVT_VARIANT() {
/*  220 */       super(W32APITypeMapper.DEFAULT);
/*      */     }
/*      */     
/*      */     public EVT_VARIANT(Pointer param1Pointer) {
/*  224 */       super(param1Pointer, 0, W32APITypeMapper.DEFAULT);
/*      */     }
/*      */     
/*      */     public void use(Pointer param1Pointer) {
/*  228 */       useMemory(param1Pointer, 0);
/*      */     }
/*      */     
/*      */     public static class ByReference extends EVT_VARIANT implements Structure.ByReference {
/*      */       public ByReference(Pointer param2Pointer) {
/*  233 */         super(param2Pointer);
/*      */       }
/*      */       
/*      */       public ByReference() {}
/*      */     }
/*      */     
/*      */     public static class ByValue
/*      */       extends EVT_VARIANT
/*      */       implements Structure.ByValue {
/*      */       public ByValue(Pointer param2Pointer) {
/*  243 */         super(param2Pointer);
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*      */       public ByValue() {}
/*      */     }
/*      */ 
/*      */     
/*      */     private int getBaseType() {
/*  253 */       return this.Type & 0x7F;
/*      */     }
/*      */     
/*      */     public boolean isArray() {
/*  257 */       return ((this.Type & 0x80) == 128);
/*      */     }
/*      */     
/*      */     public Winevt.EVT_VARIANT_TYPE getVariantType() {
/*  261 */       return Winevt.EVT_VARIANT_TYPE.values()[getBaseType()];
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void setValue(Winevt.EVT_VARIANT_TYPE param1EVT_VARIANT_TYPE, Object param1Object) {
/*  272 */       allocateMemory();
/*  273 */       if (param1EVT_VARIANT_TYPE == null) {
/*  274 */         throw new IllegalArgumentException("setValue must not be called with type set to NULL");
/*      */       }
/*  276 */       this.holder = null;
/*  277 */       if (param1Object == null || param1EVT_VARIANT_TYPE == Winevt.EVT_VARIANT_TYPE.EvtVarTypeNull) {
/*  278 */         this.Type = Winevt.EVT_VARIANT_TYPE.EvtVarTypeNull.ordinal();
/*  279 */         this.Count = 0;
/*  280 */         this.field1.writeField("pointerValue", Pointer.NULL);
/*      */       } else {
/*  282 */         switch (param1EVT_VARIANT_TYPE) {
/*      */           case EvtVarTypeAnsiString:
/*  284 */             if (param1Object.getClass().isArray() && param1Object.getClass().getComponentType() == String.class) {
/*  285 */               this.Type = param1EVT_VARIANT_TYPE.ordinal() | 0x80;
/*  286 */               StringArray stringArray = new StringArray((String[])param1Object, false);
/*  287 */               this.holder = stringArray;
/*  288 */               this.Count = ((String[])param1Object).length;
/*  289 */               this.field1.writeField("pointerValue", stringArray); break;
/*  290 */             }  if (param1Object.getClass() == String.class) {
/*  291 */               this.Type = param1EVT_VARIANT_TYPE.ordinal();
/*  292 */               Memory memory = new Memory((((String)param1Object).length() + 1));
/*  293 */               memory.setString(0L, (String)param1Object);
/*  294 */               this.holder = memory;
/*  295 */               this.Count = 0;
/*  296 */               this.field1.writeField("pointerValue", memory); break;
/*      */             } 
/*  298 */             throw new IllegalArgumentException(param1EVT_VARIANT_TYPE.name() + " must be set from String/String[]");
/*      */ 
/*      */           
/*      */           case EvtVarTypeBoolean:
/*  302 */             if (param1Object.getClass().isArray() && param1Object.getClass().getComponentType() == WinDef.BOOL.class) {
/*  303 */               this.Type = param1EVT_VARIANT_TYPE.ordinal() | 0x80;
/*  304 */               Memory memory = new Memory((((WinDef.BOOL[])param1Object).length * 4));
/*  305 */               for (byte b = 0; b < ((WinDef.BOOL[])param1Object).length; b++) {
/*  306 */                 memory.setInt((b * 4), ((WinDef.BOOL[])param1Object)[b].intValue());
/*      */               }
/*  308 */               this.holder = memory;
/*  309 */               this.Count = 0;
/*  310 */               this.field1.writeField("pointerValue", memory); break;
/*  311 */             }  if (param1Object.getClass() == WinDef.BOOL.class) {
/*  312 */               this.Type = param1EVT_VARIANT_TYPE.ordinal();
/*  313 */               this.Count = 0;
/*  314 */               this.field1.writeField("intValue", Integer.valueOf(((WinDef.BOOL)param1Object).intValue())); break;
/*      */             } 
/*  316 */             throw new IllegalArgumentException(param1EVT_VARIANT_TYPE.name() + " must be set from BOOL/BOOL[]");
/*      */ 
/*      */           
/*      */           case EvtVarTypeString:
/*      */           case EvtVarTypeEvtXml:
/*  321 */             if (param1Object.getClass().isArray() && param1Object.getClass().getComponentType() == String.class) {
/*  322 */               this.Type = param1EVT_VARIANT_TYPE.ordinal() | 0x80;
/*  323 */               StringArray stringArray = new StringArray((String[])param1Object, true);
/*  324 */               this.holder = stringArray;
/*  325 */               this.Count = ((String[])param1Object).length;
/*  326 */               this.field1.writeField("pointerValue", stringArray); break;
/*  327 */             }  if (param1Object.getClass() == String.class) {
/*  328 */               this.Type = param1EVT_VARIANT_TYPE.ordinal();
/*  329 */               Memory memory = new Memory(((((String)param1Object).length() + 1) * 2));
/*  330 */               memory.setWideString(0L, (String)param1Object);
/*  331 */               this.holder = memory;
/*  332 */               this.Count = 0;
/*  333 */               this.field1.writeField("pointerValue", memory); break;
/*      */             } 
/*  335 */             throw new IllegalArgumentException(param1EVT_VARIANT_TYPE.name() + " must be set from String/String[]");
/*      */ 
/*      */           
/*      */           case EvtVarTypeSByte:
/*      */           case EvtVarTypeByte:
/*  340 */             if (param1Object.getClass().isArray() && param1Object.getClass().getComponentType() == byte.class) {
/*  341 */               this.Type = param1EVT_VARIANT_TYPE.ordinal() | 0x80;
/*  342 */               Memory memory = new Memory((((byte[])param1Object).length * 1));
/*  343 */               memory.write(0L, (byte[])param1Object, 0, ((byte[])param1Object).length);
/*  344 */               this.holder = memory;
/*  345 */               this.Count = 0;
/*  346 */               this.field1.writeField("pointerValue", memory); break;
/*  347 */             }  if (param1Object.getClass() == byte.class) {
/*  348 */               this.Type = param1EVT_VARIANT_TYPE.ordinal();
/*  349 */               this.Count = 0;
/*  350 */               this.field1.writeField("byteValue", param1Object); break;
/*      */             } 
/*  352 */             throw new IllegalArgumentException(param1EVT_VARIANT_TYPE.name() + " must be set from byte/byte[]");
/*      */ 
/*      */           
/*      */           case EvtVarTypeInt16:
/*      */           case EvtVarTypeUInt16:
/*  357 */             if (param1Object.getClass().isArray() && param1Object.getClass().getComponentType() == short.class) {
/*  358 */               this.Type = param1EVT_VARIANT_TYPE.ordinal() | 0x80;
/*  359 */               Memory memory = new Memory((((short[])param1Object).length * 2));
/*  360 */               memory.write(0L, (short[])param1Object, 0, ((short[])param1Object).length);
/*  361 */               this.holder = memory;
/*  362 */               this.Count = 0;
/*  363 */               this.field1.writeField("pointerValue", memory); break;
/*  364 */             }  if (param1Object.getClass() == short.class) {
/*  365 */               this.Type = param1EVT_VARIANT_TYPE.ordinal();
/*  366 */               this.Count = 0;
/*  367 */               this.field1.writeField("shortValue", param1Object); break;
/*      */             } 
/*  369 */             throw new IllegalArgumentException(param1EVT_VARIANT_TYPE.name() + " must be set from short/short[]");
/*      */ 
/*      */           
/*      */           case EvtVarTypeHexInt32:
/*      */           case EvtVarTypeInt32:
/*      */           case EvtVarTypeUInt32:
/*  375 */             if (param1Object.getClass().isArray() && param1Object.getClass().getComponentType() == int.class) {
/*  376 */               this.Type = param1EVT_VARIANT_TYPE.ordinal() | 0x80;
/*  377 */               Memory memory = new Memory((((int[])param1Object).length * 4));
/*  378 */               memory.write(0L, (int[])param1Object, 0, ((int[])param1Object).length);
/*  379 */               this.holder = memory;
/*  380 */               this.Count = 0;
/*  381 */               this.field1.writeField("pointerValue", memory); break;
/*  382 */             }  if (param1Object.getClass() == int.class) {
/*  383 */               this.Type = param1EVT_VARIANT_TYPE.ordinal();
/*  384 */               this.Count = 0;
/*  385 */               this.field1.writeField("intValue", param1Object); break;
/*      */             } 
/*  387 */             throw new IllegalArgumentException(param1EVT_VARIANT_TYPE.name() + " must be set from int/int[]");
/*      */ 
/*      */           
/*      */           case EvtVarTypeHexInt64:
/*      */           case EvtVarTypeInt64:
/*      */           case EvtVarTypeUInt64:
/*  393 */             if (param1Object.getClass().isArray() && param1Object.getClass().getComponentType() == long.class) {
/*  394 */               this.Type = param1EVT_VARIANT_TYPE.ordinal() | 0x80;
/*  395 */               Memory memory = new Memory((((long[])param1Object).length * 4));
/*  396 */               memory.write(0L, (long[])param1Object, 0, ((long[])param1Object).length);
/*  397 */               this.holder = memory;
/*  398 */               this.Count = 0;
/*  399 */               this.field1.writeField("pointerValue", memory); break;
/*  400 */             }  if (param1Object.getClass() == long.class) {
/*  401 */               this.Type = param1EVT_VARIANT_TYPE.ordinal();
/*  402 */               this.Count = 0;
/*  403 */               this.field1.writeField("longValue", param1Object); break;
/*      */             } 
/*  405 */             throw new IllegalArgumentException(param1EVT_VARIANT_TYPE.name() + " must be set from long/long[]");
/*      */ 
/*      */           
/*      */           case EvtVarTypeSingle:
/*  409 */             if (param1Object.getClass().isArray() && param1Object.getClass().getComponentType() == float.class) {
/*  410 */               this.Type = param1EVT_VARIANT_TYPE.ordinal() | 0x80;
/*  411 */               Memory memory = new Memory((((float[])param1Object).length * 4));
/*  412 */               memory.write(0L, (float[])param1Object, 0, ((float[])param1Object).length);
/*  413 */               this.holder = memory;
/*  414 */               this.Count = 0;
/*  415 */               this.field1.writeField("pointerValue", memory); break;
/*  416 */             }  if (param1Object.getClass() == float.class) {
/*  417 */               this.Type = param1EVT_VARIANT_TYPE.ordinal();
/*  418 */               this.Count = 0;
/*  419 */               this.field1.writeField("floatValue", param1Object); break;
/*      */             } 
/*  421 */             throw new IllegalArgumentException(param1EVT_VARIANT_TYPE.name() + " must be set from float/float[]");
/*      */ 
/*      */           
/*      */           case EvtVarTypeDouble:
/*  425 */             if (param1Object.getClass().isArray() && param1Object.getClass().getComponentType() == double.class) {
/*  426 */               this.Type = param1EVT_VARIANT_TYPE.ordinal() | 0x80;
/*  427 */               Memory memory = new Memory((((double[])param1Object).length * 4));
/*  428 */               memory.write(0L, (double[])param1Object, 0, ((double[])param1Object).length);
/*  429 */               this.holder = memory;
/*  430 */               this.Count = 0;
/*  431 */               this.field1.writeField("pointerValue", memory); break;
/*  432 */             }  if (param1Object.getClass() == double.class) {
/*  433 */               this.Type = param1EVT_VARIANT_TYPE.ordinal();
/*  434 */               this.Count = 0;
/*  435 */               this.field1.writeField("doubleVal", param1Object); break;
/*      */             } 
/*  437 */             throw new IllegalArgumentException(param1EVT_VARIANT_TYPE.name() + " must be set from double/double[]");
/*      */ 
/*      */           
/*      */           case EvtVarTypeBinary:
/*  441 */             if (param1Object.getClass().isArray() && param1Object.getClass().getComponentType() == byte.class) {
/*  442 */               this.Type = param1EVT_VARIANT_TYPE.ordinal();
/*  443 */               Memory memory = new Memory((((byte[])param1Object).length * 1));
/*  444 */               memory.write(0L, (byte[])param1Object, 0, ((byte[])param1Object).length);
/*  445 */               this.holder = memory;
/*  446 */               this.Count = 0;
/*  447 */               this.field1.writeField("pointerValue", memory); break;
/*      */             } 
/*  449 */             throw new IllegalArgumentException(param1EVT_VARIANT_TYPE.name() + " must be set from byte[]");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           default:
/*  459 */             throw new IllegalStateException(String.format("NOT IMPLEMENTED: getValue(%s) (Array: %b, Count: %d)", new Object[] { param1EVT_VARIANT_TYPE, Boolean.valueOf(isArray()), Integer.valueOf(this.Count) }));
/*      */         } 
/*      */       } 
/*  462 */       write();
/*      */     }
/*      */     public Object getValue() {
/*      */       WinBase.FILETIME fILETIME;
/*      */       WinBase.SYSTEMTIME sYSTEMTIME;
/*      */       Guid.GUID gUID;
/*      */       WinNT.PSID pSID;
/*  469 */       Winevt.EVT_VARIANT_TYPE eVT_VARIANT_TYPE = getVariantType();
/*  470 */       switch (eVT_VARIANT_TYPE) {
/*      */         case EvtVarTypeAnsiString:
/*  472 */           return isArray() ? this.field1.getPointer().getPointer(0L).getStringArray(0L, this.Count) : this.field1.getPointer().getPointer(0L).getString(0L);
/*      */         case EvtVarTypeBoolean:
/*  474 */           if (isArray()) {
/*  475 */             int[] arrayOfInt = this.field1.getPointer().getPointer(0L).getIntArray(0L, this.Count);
/*  476 */             WinDef.BOOL[] arrayOfBOOL = new WinDef.BOOL[arrayOfInt.length];
/*  477 */             for (byte b = 0; b < arrayOfBOOL.length; b++) {
/*  478 */               arrayOfBOOL[b] = new WinDef.BOOL(arrayOfInt[b]);
/*      */             }
/*  480 */             return arrayOfBOOL;
/*      */           } 
/*  482 */           return new WinDef.BOOL(this.field1.getPointer().getInt(0L));
/*      */         
/*      */         case EvtVarTypeString:
/*      */         case EvtVarTypeEvtXml:
/*  486 */           return isArray() ? this.field1.getPointer().getPointer(0L).getWideStringArray(0L, this.Count) : this.field1.getPointer().getPointer(0L).getWideString(0L);
/*      */         case EvtVarTypeFileTime:
/*  488 */           if (isArray()) {
/*  489 */             WinBase.FILETIME fILETIME1 = (WinBase.FILETIME)Structure.newInstance(WinBase.FILETIME.class, this.field1.getPointer().getPointer(0L));
/*  490 */             fILETIME1.read();
/*  491 */             return fILETIME1.toArray(this.Count);
/*      */           } 
/*  493 */           fILETIME = new WinBase.FILETIME(this.field1.getPointer());
/*  494 */           fILETIME.read();
/*  495 */           return fILETIME;
/*      */         
/*      */         case EvtVarTypeSysTime:
/*  498 */           if (isArray()) {
/*  499 */             WinBase.SYSTEMTIME sYSTEMTIME1 = (WinBase.SYSTEMTIME)Structure.newInstance(WinBase.SYSTEMTIME.class, this.field1.getPointer().getPointer(0L));
/*  500 */             sYSTEMTIME1.read();
/*  501 */             return sYSTEMTIME1.toArray(this.Count);
/*      */           } 
/*  503 */           sYSTEMTIME = (WinBase.SYSTEMTIME)Structure.newInstance(WinBase.SYSTEMTIME.class, this.field1.getPointer().getPointer(0L));
/*  504 */           sYSTEMTIME.read();
/*  505 */           return sYSTEMTIME;
/*      */         
/*      */         case EvtVarTypeSByte:
/*      */         case EvtVarTypeByte:
/*  509 */           return isArray() ? this.field1.getPointer().getPointer(0L).getByteArray(0L, this.Count) : Byte.valueOf(this.field1.getPointer().getByte(0L));
/*      */         case EvtVarTypeInt16:
/*      */         case EvtVarTypeUInt16:
/*  512 */           return isArray() ? this.field1.getPointer().getPointer(0L).getShortArray(0L, this.Count) : Short.valueOf(this.field1.getPointer().getShort(0L));
/*      */         case EvtVarTypeHexInt32:
/*      */         case EvtVarTypeInt32:
/*      */         case EvtVarTypeUInt32:
/*  516 */           return isArray() ? this.field1.getPointer().getPointer(0L).getIntArray(0L, this.Count) : Integer.valueOf(this.field1.getPointer().getInt(0L));
/*      */         case EvtVarTypeHexInt64:
/*      */         case EvtVarTypeInt64:
/*      */         case EvtVarTypeUInt64:
/*  520 */           return isArray() ? this.field1.getPointer().getPointer(0L).getLongArray(0L, this.Count) : Long.valueOf(this.field1.getPointer().getLong(0L));
/*      */         case EvtVarTypeSingle:
/*  522 */           return isArray() ? this.field1.getPointer().getPointer(0L).getFloatArray(0L, this.Count) : Float.valueOf(this.field1.getPointer().getFloat(0L));
/*      */         case EvtVarTypeDouble:
/*  524 */           return isArray() ? this.field1.getPointer().getPointer(0L).getDoubleArray(0L, this.Count) : Double.valueOf(this.field1.getPointer().getDouble(0L));
/*      */         case EvtVarTypeBinary:
/*  526 */           assert !isArray();
/*  527 */           return this.field1.getPointer().getPointer(0L).getByteArray(0L, this.Count);
/*      */         case EvtVarTypeNull:
/*  529 */           return null;
/*      */         case EvtVarTypeGuid:
/*  531 */           if (isArray()) {
/*  532 */             Guid.GUID gUID1 = (Guid.GUID)Structure.newInstance(Guid.GUID.class, this.field1.getPointer().getPointer(0L));
/*  533 */             gUID1.read();
/*  534 */             return gUID1.toArray(this.Count);
/*      */           } 
/*  536 */           gUID = (Guid.GUID)Structure.newInstance(Guid.GUID.class, this.field1.getPointer().getPointer(0L));
/*  537 */           gUID.read();
/*  538 */           return gUID;
/*      */         
/*      */         case EvtVarTypeSid:
/*  541 */           if (isArray()) {
/*  542 */             WinNT.PSID pSID1 = (WinNT.PSID)Structure.newInstance(WinNT.PSID.class, this.field1.getPointer().getPointer(0L));
/*  543 */             pSID1.read();
/*  544 */             return pSID1.toArray(this.Count);
/*      */           } 
/*  546 */           pSID = (WinNT.PSID)Structure.newInstance(WinNT.PSID.class, this.field1.getPointer().getPointer(0L));
/*  547 */           pSID.read();
/*  548 */           return pSID;
/*      */         
/*      */         case EvtVarTypeSizeT:
/*  551 */           if (isArray()) {
/*  552 */             long[] arrayOfLong = this.field1.getPointer().getPointer(0L).getLongArray(0L, this.Count);
/*  553 */             BaseTSD.SIZE_T[] arrayOfSIZE_T = new BaseTSD.SIZE_T[arrayOfLong.length];
/*  554 */             for (byte b = 0; b < arrayOfSIZE_T.length; b++) {
/*  555 */               arrayOfSIZE_T[b] = new BaseTSD.SIZE_T(arrayOfLong[b]);
/*      */             }
/*  557 */             return arrayOfSIZE_T;
/*      */           } 
/*  559 */           return new BaseTSD.SIZE_T(this.field1.getPointer().getLong(0L));
/*      */         
/*      */         case EvtVarTypeEvtHandle:
/*  562 */           if (isArray()) {
/*  563 */             Pointer[] arrayOfPointer = this.field1.getPointer().getPointer(0L).getPointerArray(0L, this.Count);
/*  564 */             WinNT.HANDLE[] arrayOfHANDLE = new WinNT.HANDLE[arrayOfPointer.length];
/*  565 */             for (byte b = 0; b < arrayOfHANDLE.length; b++) {
/*  566 */               arrayOfHANDLE[b] = new WinNT.HANDLE(arrayOfPointer[b]);
/*      */             }
/*  568 */             return arrayOfHANDLE;
/*      */           } 
/*  570 */           return new WinNT.HANDLE(this.field1.getPointer().getPointer(0L));
/*      */       } 
/*      */       
/*  573 */       throw new IllegalStateException(String.format("NOT IMPLEMENTED: getValue(%s) (Array: %b, Count: %d)", new Object[] { eVT_VARIANT_TYPE, Boolean.valueOf(isArray()), Integer.valueOf(this.Count) }));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @FieldOrder({"Server", "User", "Domain", "Password", "Flags"})
/*      */   public static class EVT_RPC_LOGIN
/*      */     extends Structure
/*      */   {
/*      */     public String Server;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public String User;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public String Domain;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public String Password;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public int Flags;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public EVT_RPC_LOGIN() {
/*  629 */       super(W32APITypeMapper.UNICODE);
/*      */     }
/*      */     
/*      */     public EVT_RPC_LOGIN(String param1String1, String param1String2, String param1String3, String param1String4, int param1Int) {
/*  633 */       super(W32APITypeMapper.UNICODE);
/*  634 */       this.Server = param1String1;
/*  635 */       this.User = param1String2;
/*  636 */       this.Domain = param1String3;
/*  637 */       this.Password = param1String4;
/*  638 */       this.Flags = param1Int;
/*      */     }
/*      */     
/*      */     public EVT_RPC_LOGIN(Pointer param1Pointer) {
/*  642 */       super(param1Pointer, 0, W32APITypeMapper.UNICODE);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static class ByReference
/*      */       extends EVT_RPC_LOGIN
/*      */       implements Structure.ByReference {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static class ByValue
/*      */       extends EVT_RPC_LOGIN
/*      */       implements Structure.ByValue {}
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static class EVT_HANDLE
/*      */     extends WinNT.HANDLE
/*      */   {
/*      */     public EVT_HANDLE() {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public EVT_HANDLE(Pointer param1Pointer) {
/* 1701 */       super(param1Pointer);
/*      */     }
/*      */   }
/*      */   
/*      */   public static interface EVT_EVENT_PROPERTY_ID {
/*      */     public static final int EvtEventQueryIDs = 0;
/*      */     public static final int EvtEventPath = 1;
/*      */     public static final int EvtEventPropertyIdEND = 2;
/*      */   }
/*      */   
/*      */   public static interface EVT_QUERY_PROPERTY_ID {
/*      */     public static final int EvtQueryNames = 0;
/*      */     public static final int EvtQueryStatuses = 1;
/*      */     public static final int EvtQueryPropertyIdEND = 2;
/*      */   }
/*      */   
/*      */   public static interface EVT_EVENT_METADATA_PROPERTY_ID {
/*      */     public static final int EventMetadataEventID = 0;
/*      */     public static final int EventMetadataEventVersion = 1;
/*      */     public static final int EventMetadataEventChannel = 2;
/*      */     public static final int EventMetadataEventLevel = 3;
/*      */     public static final int EventMetadataEventOpcode = 4;
/*      */     public static final int EventMetadataEventTask = 5;
/*      */     public static final int EventMetadataEventKeyword = 6;
/*      */     public static final int EventMetadataEventMessageID = 7;
/*      */     public static final int EventMetadataEventTemplate = 8;
/*      */     public static final int EvtEventMetadataPropertyIdEND = 9;
/*      */   }
/*      */   
/*      */   public static interface EVT_PUBLISHER_METADATA_PROPERTY_ID {
/*      */     public static final int EvtPublisherMetadataPublisherGuid = 0;
/*      */     public static final int EvtPublisherMetadataResourceFilePath = 1;
/*      */     public static final int EvtPublisherMetadataParameterFilePath = 2;
/*      */     public static final int EvtPublisherMetadataMessageFilePath = 3;
/*      */     public static final int EvtPublisherMetadataHelpLink = 4;
/*      */     public static final int EvtPublisherMetadataPublisherMessageID = 5;
/*      */     public static final int EvtPublisherMetadataChannelReferences = 6;
/*      */     public static final int EvtPublisherMetadataChannelReferencePath = 7;
/*      */     public static final int EvtPublisherMetadataChannelReferenceIndex = 8;
/*      */     public static final int EvtPublisherMetadataChannelReferenceID = 9;
/*      */     public static final int EvtPublisherMetadataChannelReferenceFlags = 10;
/*      */     public static final int EvtPublisherMetadataChannelReferenceMessageID = 11;
/*      */     public static final int EvtPublisherMetadataLevels = 12;
/*      */     public static final int EvtPublisherMetadataLevelName = 13;
/*      */     public static final int EvtPublisherMetadataLevelValue = 14;
/*      */     public static final int EvtPublisherMetadataLevelMessageID = 15;
/*      */     public static final int EvtPublisherMetadataTasks = 16;
/*      */     public static final int EvtPublisherMetadataTaskName = 17;
/*      */     public static final int EvtPublisherMetadataTaskEventGuid = 18;
/*      */     public static final int EvtPublisherMetadataTaskValue = 19;
/*      */     public static final int EvtPublisherMetadataTaskMessageID = 20;
/*      */     public static final int EvtPublisherMetadataOpcodes = 21;
/*      */     public static final int EvtPublisherMetadataOpcodeName = 22;
/*      */     public static final int EvtPublisherMetadataOpcodeValue = 23;
/*      */     public static final int EvtPublisherMetadataOpcodeMessageID = 24;
/*      */     public static final int EvtPublisherMetadataKeywords = 25;
/*      */     public static final int EvtPublisherMetadataKeywordName = 26;
/*      */     public static final int EvtPublisherMetadataKeywordValue = 27;
/*      */     public static final int EvtPublisherMetadataKeywordMessageID = 28;
/*      */     public static final int EvtPublisherMetadataPropertyIdEND = 29;
/*      */   }
/*      */   
/*      */   public static interface EVT_CHANNEL_REFERENCE_FLAGS {
/*      */     public static final int EvtChannelReferenceImported = 1;
/*      */   }
/*      */   
/*      */   public static interface EVT_CHANNEL_SID_TYPE {
/*      */     public static final int EvtChannelSidTypeNone = 0;
/*      */     public static final int EvtChannelSidTypePublishing = 1;
/*      */   }
/*      */   
/*      */   public static interface EVT_CHANNEL_CLOCK_TYPE {
/*      */     public static final int EvtChannelClockTypeSystemTime = 0;
/*      */     public static final int EvtChannelClockTypeQPC = 1;
/*      */   }
/*      */   
/*      */   public static interface EVT_CHANNEL_ISOLATION_TYPE {
/*      */     public static final int EvtChannelIsolationTypeApplication = 0;
/*      */     public static final int EvtChannelIsolationTypeSystem = 1;
/*      */     public static final int EvtChannelIsolationTypeCustom = 2;
/*      */   }
/*      */   
/*      */   public static interface EVT_CHANNEL_TYPE {
/*      */     public static final int EvtChannelTypeAdmin = 0;
/*      */     public static final int EvtChannelTypeOperational = 1;
/*      */     public static final int EvtChannelTypeAnalytic = 2;
/*      */     public static final int EvtChannelTypeDebug = 3;
/*      */   }
/*      */   
/*      */   public static interface EVT_CHANNEL_CONFIG_PROPERTY_ID {
/*      */     public static final int EvtChannelConfigEnabled = 0;
/*      */     public static final int EvtChannelConfigIsolation = 1;
/*      */     public static final int EvtChannelConfigType = 2;
/*      */     public static final int EvtChannelConfigOwningPublisher = 3;
/*      */     public static final int EvtChannelConfigClassicEventlog = 4;
/*      */     public static final int EvtChannelConfigAccess = 5;
/*      */     public static final int EvtChannelLoggingConfigRetention = 6;
/*      */     public static final int EvtChannelLoggingConfigAutoBackup = 7;
/*      */     public static final int EvtChannelLoggingConfigMaxSize = 8;
/*      */     public static final int EvtChannelLoggingConfigLogFilePath = 9;
/*      */     public static final int EvtChannelPublishingConfigLevel = 10;
/*      */     public static final int EvtChannelPublishingConfigKeywords = 11;
/*      */     public static final int EvtChannelPublishingConfigControlGuid = 12;
/*      */     public static final int EvtChannelPublishingConfigBufferSize = 13;
/*      */     public static final int EvtChannelPublishingConfigMinBuffers = 14;
/*      */     public static final int EvtChannelPublishingConfigMaxBuffers = 15;
/*      */     public static final int EvtChannelPublishingConfigLatency = 16;
/*      */     public static final int EvtChannelPublishingConfigClockType = 17;
/*      */     public static final int EvtChannelPublishingConfigSidType = 18;
/*      */     public static final int EvtChannelPublisherList = 19;
/*      */     public static final int EvtChannelPublishingConfigFileMax = 20;
/*      */     public static final int EvtChannelConfigPropertyIdEND = 21;
/*      */   }
/*      */   
/*      */   public static interface EVT_EXPORTLOG_FLAGS {
/*      */     public static final int EvtExportLogChannelPath = 1;
/*      */     public static final int EvtExportLogFilePath = 2;
/*      */     public static final int EvtExportLogTolerateQueryErrors = 4096;
/*      */     public static final int EvtExportLogOverwrite = 8192;
/*      */   }
/*      */   
/*      */   public static interface EVT_LOG_PROPERTY_ID {
/*      */     public static final int EvtLogCreationTime = 0;
/*      */     public static final int EvtLogLastAccessTime = 1;
/*      */     public static final int EvtLogLastWriteTime = 2;
/*      */     public static final int EvtLogFileSize = 3;
/*      */     public static final int EvtLogAttributes = 4;
/*      */     public static final int EvtLogNumberOfLogRecords = 5;
/*      */     public static final int EvtLogOldestRecordNumber = 6;
/*      */     public static final int EvtLogFull = 7;
/*      */   }
/*      */   
/*      */   public static interface EVT_OPEN_LOG_FLAGS {
/*      */     public static final int EvtOpenChannelPath = 1;
/*      */     public static final int EvtOpenFilePath = 2;
/*      */   }
/*      */   
/*      */   public static interface EVT_FORMAT_MESSAGE_FLAGS {
/*      */     public static final int EvtFormatMessageEvent = 1;
/*      */     public static final int EvtFormatMessageLevel = 2;
/*      */     public static final int EvtFormatMessageTask = 3;
/*      */     public static final int EvtFormatMessageOpcode = 4;
/*      */     public static final int EvtFormatMessageKeyword = 5;
/*      */     public static final int EvtFormatMessageChannel = 6;
/*      */     public static final int EvtFormatMessageProvider = 7;
/*      */     public static final int EvtFormatMessageId = 8;
/*      */     public static final int EvtFormatMessageXml = 9;
/*      */   }
/*      */   
/*      */   public static interface EVT_RENDER_FLAGS {
/*      */     public static final int EvtRenderEventValues = 0;
/*      */     public static final int EvtRenderEventXml = 1;
/*      */     public static final int EvtRenderBookmark = 2;
/*      */   }
/*      */   
/*      */   public static interface EVT_RENDER_CONTEXT_FLAGS {
/*      */     public static final int EvtRenderContextValues = 0;
/*      */     public static final int EvtRenderContextSystem = 1;
/*      */     public static final int EvtRenderContextUser = 2;
/*      */   }
/*      */   
/*      */   public static interface EVT_SYSTEM_PROPERTY_ID {
/*      */     public static final int EvtSystemProviderName = 0;
/*      */     public static final int EvtSystemProviderGuid = 1;
/*      */     public static final int EvtSystemEventID = 2;
/*      */     public static final int EvtSystemQualifiers = 3;
/*      */     public static final int EvtSystemLevel = 4;
/*      */     public static final int EvtSystemTask = 5;
/*      */     public static final int EvtSystemOpcode = 6;
/*      */     public static final int EvtSystemKeywords = 7;
/*      */     public static final int EvtSystemTimeCreated = 8;
/*      */     public static final int EvtSystemEventRecordId = 9;
/*      */     public static final int EvtSystemActivityID = 10;
/*      */     public static final int EvtSystemRelatedActivityID = 11;
/*      */     public static final int EvtSystemProcessID = 12;
/*      */     public static final int EvtSystemThreadID = 13;
/*      */     public static final int EvtSystemChannel = 14;
/*      */     public static final int EvtSystemComputer = 15;
/*      */     public static final int EvtSystemUserID = 16;
/*      */     public static final int EvtSystemVersion = 17;
/*      */     public static final int EvtSystemPropertyIdEND = 18;
/*      */   }
/*      */   
/*      */   public static interface EVT_SUBSCRIBE_NOTIFY_ACTION {
/*      */     public static final int EvtSubscribeActionError = 0;
/*      */     public static final int EvtSubscribeActionDeliver = 1;
/*      */   }
/*      */   
/*      */   public static interface EVT_SUBSCRIBE_FLAGS {
/*      */     public static final int EvtSubscribeToFutureEvents = 1;
/*      */     public static final int EvtSubscribeStartAtOldestRecord = 2;
/*      */     public static final int EvtSubscribeStartAfterBookmark = 3;
/*      */     public static final int EvtSubscribeOriginMask = 3;
/*      */     public static final int EvtSubscribeTolerateQueryErrors = 4096;
/*      */     public static final int EvtSubscribeStrict = 65536;
/*      */   }
/*      */   
/*      */   public static interface EVT_SEEK_FLAGS {
/*      */     public static final int EvtSeekRelativeToFirst = 1;
/*      */     public static final int EvtSeekRelativeToLast = 2;
/*      */     public static final int EvtSeekRelativeToCurrent = 3;
/*      */     public static final int EvtSeekRelativeToBookmark = 4;
/*      */     public static final int EvtSeekOriginMask = 7;
/*      */     public static final int EvtSeekStrict = 65536;
/*      */   }
/*      */   
/*      */   public static interface EVT_QUERY_FLAGS {
/*      */     public static final int EvtQueryChannelPath = 1;
/*      */     public static final int EvtQueryFilePath = 2;
/*      */     public static final int EvtQueryForwardDirection = 256;
/*      */     public static final int EvtQueryReverseDirection = 512;
/*      */     public static final int EvtQueryTolerateQueryErrors = 4096;
/*      */   }
/*      */   
/*      */   public static interface EVT_RPC_LOGIN_FLAGS {
/*      */     public static final int EvtRpcLoginAuthDefault = 0;
/*      */     public static final int EvtRpcLoginAuthNegotiate = 1;
/*      */     public static final int EvtRpcLoginAuthKerberos = 2;
/*      */     public static final int EvtRpcLoginAuthNTLM = 3;
/*      */   }
/*      */   
/*      */   public static interface EVT_LOGIN_CLASS {
/*      */     public static final int EvtRpcLogin = 1;
/*      */   }
/*      */ }


/* Location:              C:\Arremate\Arremate.jar!\com\sun\jna\platform\win32\Winevt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */