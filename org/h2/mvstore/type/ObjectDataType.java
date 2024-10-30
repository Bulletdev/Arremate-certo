/*      */ package org.h2.mvstore.type;
/*      */ 
/*      */ import java.io.ByteArrayInputStream;
/*      */ import java.io.ByteArrayOutputStream;
/*      */ import java.io.ObjectInputStream;
/*      */ import java.io.ObjectOutputStream;
/*      */ import java.lang.reflect.Array;
/*      */ import java.math.BigDecimal;
/*      */ import java.math.BigInteger;
/*      */ import java.nio.ByteBuffer;
/*      */ import java.util.Arrays;
/*      */ import java.util.Date;
/*      */ import java.util.HashMap;
/*      */ import java.util.UUID;
/*      */ import org.h2.mvstore.DataUtils;
/*      */ import org.h2.mvstore.WriteBuffer;
/*      */ import org.h2.util.New;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class ObjectDataType
/*      */   implements DataType
/*      */ {
/*      */   static final int TYPE_NULL = 0;
/*      */   static final int TYPE_BOOLEAN = 1;
/*      */   static final int TYPE_BYTE = 2;
/*      */   static final int TYPE_SHORT = 3;
/*      */   static final int TYPE_INT = 4;
/*      */   static final int TYPE_LONG = 5;
/*      */   static final int TYPE_BIG_INTEGER = 6;
/*      */   static final int TYPE_FLOAT = 7;
/*      */   static final int TYPE_DOUBLE = 8;
/*      */   static final int TYPE_BIG_DECIMAL = 9;
/*      */   static final int TYPE_CHAR = 10;
/*      */   static final int TYPE_STRING = 11;
/*      */   static final int TYPE_UUID = 12;
/*      */   static final int TYPE_DATE = 13;
/*      */   static final int TYPE_ARRAY = 14;
/*      */   static final int TYPE_SERIALIZED_OBJECT = 19;
/*      */   static final int TAG_BOOLEAN_TRUE = 32;
/*      */   static final int TAG_INTEGER_NEGATIVE = 33;
/*      */   static final int TAG_INTEGER_FIXED = 34;
/*      */   static final int TAG_LONG_NEGATIVE = 35;
/*      */   static final int TAG_LONG_FIXED = 36;
/*      */   static final int TAG_BIG_INTEGER_0 = 37;
/*      */   static final int TAG_BIG_INTEGER_1 = 38;
/*      */   static final int TAG_BIG_INTEGER_SMALL = 39;
/*      */   static final int TAG_FLOAT_0 = 40;
/*      */   static final int TAG_FLOAT_1 = 41;
/*      */   static final int TAG_FLOAT_FIXED = 42;
/*      */   static final int TAG_DOUBLE_0 = 43;
/*      */   static final int TAG_DOUBLE_1 = 44;
/*      */   static final int TAG_DOUBLE_FIXED = 45;
/*      */   static final int TAG_BIG_DECIMAL_0 = 46;
/*      */   static final int TAG_BIG_DECIMAL_1 = 47;
/*      */   static final int TAG_BIG_DECIMAL_SMALL = 48;
/*      */   static final int TAG_BIG_DECIMAL_SMALL_SCALED = 49;
/*      */   static final int TAG_INTEGER_0_15 = 64;
/*      */   static final int TAG_LONG_0_7 = 80;
/*      */   static final int TAG_STRING_0_15 = 88;
/*      */   static final int TAG_BYTE_ARRAY_0_15 = 104;
/*   85 */   static final int FLOAT_ZERO_BITS = Float.floatToIntBits(0.0F);
/*   86 */   static final int FLOAT_ONE_BITS = Float.floatToIntBits(1.0F);
/*   87 */   static final long DOUBLE_ZERO_BITS = Double.doubleToLongBits(0.0D);
/*   88 */   static final long DOUBLE_ONE_BITS = Double.doubleToLongBits(1.0D);
/*      */   
/*   90 */   static final Class<?>[] COMMON_CLASSES = new Class[] { boolean.class, byte.class, short.class, char.class, int.class, long.class, float.class, double.class, Object.class, Boolean.class, Byte.class, Short.class, Character.class, Integer.class, Long.class, BigInteger.class, Float.class, Double.class, BigDecimal.class, String.class, UUID.class, Date.class };
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*   97 */   private static final HashMap<Class<?>, Integer> COMMON_CLASSES_MAP = New.hashMap();
/*      */ 
/*      */   
/*  100 */   private AutoDetectDataType last = new StringType(this);
/*      */ 
/*      */   
/*      */   public int compare(Object paramObject1, Object paramObject2) {
/*  104 */     return this.last.compare(paramObject1, paramObject2);
/*      */   }
/*      */ 
/*      */   
/*      */   public int getMemory(Object paramObject) {
/*  109 */     return this.last.getMemory(paramObject);
/*      */   }
/*      */ 
/*      */   
/*      */   public void read(ByteBuffer paramByteBuffer, Object[] paramArrayOfObject, int paramInt, boolean paramBoolean) {
/*  114 */     for (byte b = 0; b < paramInt; b++) {
/*  115 */       paramArrayOfObject[b] = read(paramByteBuffer);
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public void write(WriteBuffer paramWriteBuffer, Object[] paramArrayOfObject, int paramInt, boolean paramBoolean) {
/*  121 */     for (byte b = 0; b < paramInt; b++) {
/*  122 */       write(paramWriteBuffer, paramArrayOfObject[b]);
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public void write(WriteBuffer paramWriteBuffer, Object paramObject) {
/*  128 */     this.last.write(paramWriteBuffer, paramObject);
/*      */   }
/*      */   
/*      */   private AutoDetectDataType newType(int paramInt) {
/*  132 */     switch (paramInt) {
/*      */       case 0:
/*  134 */         return new NullType(this);
/*      */       case 1:
/*  136 */         return new BooleanType(this);
/*      */       case 2:
/*  138 */         return new ByteType(this);
/*      */       case 3:
/*  140 */         return new ShortType(this);
/*      */       case 10:
/*  142 */         return new CharacterType(this);
/*      */       case 4:
/*  144 */         return new IntegerType(this);
/*      */       case 5:
/*  146 */         return new LongType(this);
/*      */       case 7:
/*  148 */         return new FloatType(this);
/*      */       case 8:
/*  150 */         return new DoubleType(this);
/*      */       case 6:
/*  152 */         return new BigIntegerType(this);
/*      */       case 9:
/*  154 */         return new BigDecimalType(this);
/*      */       case 11:
/*  156 */         return new StringType(this);
/*      */       case 12:
/*  158 */         return new UUIDType(this);
/*      */       case 13:
/*  160 */         return new DateType(this);
/*      */       case 14:
/*  162 */         return new ObjectArrayType(this);
/*      */       case 19:
/*  164 */         return new SerializedObjectType(this);
/*      */     } 
/*  166 */     throw DataUtils.newIllegalStateException(3, "Unsupported type {0}", new Object[] { Integer.valueOf(paramInt) });
/*      */   }
/*      */ 
/*      */   
/*      */   public Object read(ByteBuffer paramByteBuffer) {
/*      */     byte b1;
/*  172 */     byte b = paramByteBuffer.get();
/*      */     
/*  174 */     if (b <= 19) {
/*  175 */       b1 = b;
/*      */     } else {
/*  177 */       switch (b) {
/*      */         case 32:
/*  179 */           b1 = 1;
/*      */           break;
/*      */         case 33:
/*      */         case 34:
/*  183 */           b1 = 4;
/*      */           break;
/*      */         case 35:
/*      */         case 36:
/*  187 */           b1 = 5;
/*      */           break;
/*      */         case 37:
/*      */         case 38:
/*      */         case 39:
/*  192 */           b1 = 6;
/*      */           break;
/*      */         case 40:
/*      */         case 41:
/*      */         case 42:
/*  197 */           b1 = 7;
/*      */           break;
/*      */         case 43:
/*      */         case 44:
/*      */         case 45:
/*  202 */           b1 = 8;
/*      */           break;
/*      */         case 46:
/*      */         case 47:
/*      */         case 48:
/*      */         case 49:
/*  208 */           b1 = 9;
/*      */           break;
/*      */         default:
/*  211 */           if (b >= 64 && b <= 79) {
/*  212 */             b1 = 4; break;
/*  213 */           }  if (b >= 88 && b <= 103) {
/*      */             
/*  215 */             b1 = 11; break;
/*  216 */           }  if (b >= 80 && b <= 87) {
/*  217 */             b1 = 5; break;
/*  218 */           }  if (b >= 104 && b <= 119) {
/*      */             
/*  220 */             b1 = 14; break;
/*      */           } 
/*  222 */           throw DataUtils.newIllegalStateException(6, "Unknown tag {0}", new Object[] { Integer.valueOf(b) });
/*      */       } 
/*      */ 
/*      */ 
/*      */     
/*      */     } 
/*  228 */     AutoDetectDataType autoDetectDataType = this.last;
/*  229 */     if (b1 != autoDetectDataType.typeId) {
/*  230 */       this.last = autoDetectDataType = newType(b1);
/*      */     }
/*  232 */     return autoDetectDataType.read(paramByteBuffer, b);
/*      */   }
/*      */   
/*      */   private static int getTypeId(Object paramObject) {
/*  236 */     if (paramObject instanceof Integer)
/*  237 */       return 4; 
/*  238 */     if (paramObject instanceof String)
/*  239 */       return 11; 
/*  240 */     if (paramObject instanceof Long)
/*  241 */       return 5; 
/*  242 */     if (paramObject instanceof Double)
/*  243 */       return 8; 
/*  244 */     if (paramObject instanceof Float)
/*  245 */       return 7; 
/*  246 */     if (paramObject instanceof Boolean)
/*  247 */       return 1; 
/*  248 */     if (paramObject instanceof UUID)
/*  249 */       return 12; 
/*  250 */     if (paramObject instanceof Byte)
/*  251 */       return 2; 
/*  252 */     if (paramObject instanceof Short)
/*  253 */       return 3; 
/*  254 */     if (paramObject instanceof Character)
/*  255 */       return 10; 
/*  256 */     if (paramObject == null)
/*  257 */       return 0; 
/*  258 */     if (isDate(paramObject))
/*  259 */       return 13; 
/*  260 */     if (isBigInteger(paramObject))
/*  261 */       return 6; 
/*  262 */     if (isBigDecimal(paramObject))
/*  263 */       return 9; 
/*  264 */     if (paramObject.getClass().isArray()) {
/*  265 */       return 14;
/*      */     }
/*  267 */     return 19;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   AutoDetectDataType switchType(Object paramObject) {
/*  277 */     int i = getTypeId(paramObject);
/*  278 */     AutoDetectDataType autoDetectDataType = this.last;
/*  279 */     if (i != autoDetectDataType.typeId) {
/*  280 */       this.last = autoDetectDataType = newType(i);
/*      */     }
/*  282 */     return autoDetectDataType;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   static boolean isBigInteger(Object paramObject) {
/*  292 */     return (paramObject instanceof BigInteger && paramObject.getClass() == BigInteger.class);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   static boolean isBigDecimal(Object paramObject) {
/*  302 */     return (paramObject instanceof BigDecimal && paramObject.getClass() == BigDecimal.class);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   static boolean isDate(Object paramObject) {
/*  312 */     return (paramObject instanceof Date && paramObject.getClass() == Date.class);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   static boolean isArray(Object paramObject) {
/*  322 */     return (paramObject != null && paramObject.getClass().isArray());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   static Integer getCommonClassId(Class<?> paramClass) {
/*  332 */     HashMap<Class<?>, Integer> hashMap = COMMON_CLASSES_MAP;
/*  333 */     if (hashMap.size() == 0)
/*      */     {
/*      */       
/*  336 */       synchronized (hashMap) {
/*  337 */         if (hashMap.size() == 0) {
/*  338 */           byte b; int i; for (b = 0, i = COMMON_CLASSES.length; b < i; b++) {
/*  339 */             hashMap.put(COMMON_CLASSES[b], Integer.valueOf(b));
/*      */           }
/*      */         } 
/*      */       } 
/*      */     }
/*  344 */     return hashMap.get(paramClass);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static byte[] serialize(Object paramObject) {
/*      */     try {
/*  355 */       ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
/*  356 */       ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
/*  357 */       objectOutputStream.writeObject(paramObject);
/*  358 */       return byteArrayOutputStream.toByteArray();
/*  359 */     } catch (Throwable throwable) {
/*  360 */       throw DataUtils.newIllegalArgumentException("Could not serialize {0}", new Object[] { paramObject, throwable });
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
/*      */   public static Object deserialize(byte[] paramArrayOfbyte) {
/*      */     try {
/*  373 */       ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(paramArrayOfbyte);
/*  374 */       ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
/*  375 */       return objectInputStream.readObject();
/*  376 */     } catch (Throwable throwable) {
/*  377 */       throw DataUtils.newIllegalArgumentException("Could not deserialize {0}", new Object[] { Arrays.toString(paramArrayOfbyte), throwable });
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int compareNotNull(byte[] paramArrayOfbyte1, byte[] paramArrayOfbyte2) {
/*  395 */     if (paramArrayOfbyte1 == paramArrayOfbyte2) {
/*  396 */       return 0;
/*      */     }
/*  398 */     int i = Math.min(paramArrayOfbyte1.length, paramArrayOfbyte2.length);
/*  399 */     for (byte b = 0; b < i; b++) {
/*  400 */       int j = paramArrayOfbyte1[b] & 0xFF;
/*  401 */       int k = paramArrayOfbyte2[b] & 0xFF;
/*  402 */       if (j != k) {
/*  403 */         return (j > k) ? 1 : -1;
/*      */       }
/*      */     } 
/*  406 */     return Integer.signum(paramArrayOfbyte1.length - paramArrayOfbyte2.length);
/*      */   }
/*      */ 
/*      */   
/*      */   static abstract class AutoDetectDataType
/*      */     implements DataType
/*      */   {
/*      */     protected final ObjectDataType base;
/*      */     
/*      */     protected final int typeId;
/*      */     
/*      */     AutoDetectDataType(ObjectDataType param1ObjectDataType, int param1Int) {
/*  418 */       this.base = param1ObjectDataType;
/*  419 */       this.typeId = param1Int;
/*      */     }
/*      */ 
/*      */     
/*      */     public int getMemory(Object param1Object) {
/*  424 */       return getType(param1Object).getMemory(param1Object);
/*      */     }
/*      */ 
/*      */     
/*      */     public int compare(Object param1Object1, Object param1Object2) {
/*  429 */       AutoDetectDataType autoDetectDataType1 = getType(param1Object1);
/*  430 */       AutoDetectDataType autoDetectDataType2 = getType(param1Object2);
/*  431 */       int i = autoDetectDataType1.typeId - autoDetectDataType2.typeId;
/*  432 */       if (i == 0) {
/*  433 */         return autoDetectDataType1.compare(param1Object1, param1Object2);
/*      */       }
/*  435 */       return Integer.signum(i);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public void write(WriteBuffer param1WriteBuffer, Object[] param1ArrayOfObject, int param1Int, boolean param1Boolean) {
/*  441 */       for (byte b = 0; b < param1Int; b++) {
/*  442 */         write(param1WriteBuffer, param1ArrayOfObject[b]);
/*      */       }
/*      */     }
/*      */ 
/*      */     
/*      */     public void write(WriteBuffer param1WriteBuffer, Object param1Object) {
/*  448 */       getType(param1Object).write(param1WriteBuffer, param1Object);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public void read(ByteBuffer param1ByteBuffer, Object[] param1ArrayOfObject, int param1Int, boolean param1Boolean) {
/*  454 */       for (byte b = 0; b < param1Int; b++) {
/*  455 */         param1ArrayOfObject[b] = read(param1ByteBuffer);
/*      */       }
/*      */     }
/*      */ 
/*      */     
/*      */     public final Object read(ByteBuffer param1ByteBuffer) {
/*  461 */       throw DataUtils.newIllegalStateException(3, "Internal error", new Object[0]);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     AutoDetectDataType getType(Object param1Object) {
/*  472 */       return this.base.switchType(param1Object);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     abstract Object read(ByteBuffer param1ByteBuffer, int param1Int);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   static class NullType
/*      */     extends AutoDetectDataType
/*      */   {
/*      */     NullType(ObjectDataType param1ObjectDataType) {
/*  492 */       super(param1ObjectDataType, 0);
/*      */     }
/*      */ 
/*      */     
/*      */     public int compare(Object param1Object1, Object param1Object2) {
/*  497 */       if (param1Object1 == null && param1Object2 == null)
/*  498 */         return 0; 
/*  499 */       if (param1Object1 == null)
/*  500 */         return -1; 
/*  501 */       if (param1Object2 == null) {
/*  502 */         return 1;
/*      */       }
/*  504 */       return super.compare(param1Object1, param1Object2);
/*      */     }
/*      */ 
/*      */     
/*      */     public int getMemory(Object param1Object) {
/*  509 */       return (param1Object == null) ? 0 : super.getMemory(param1Object);
/*      */     }
/*      */ 
/*      */     
/*      */     public void write(WriteBuffer param1WriteBuffer, Object param1Object) {
/*  514 */       if (param1Object != null) {
/*  515 */         super.write(param1WriteBuffer, param1Object);
/*      */         return;
/*      */       } 
/*  518 */       param1WriteBuffer.put((byte)0);
/*      */     }
/*      */ 
/*      */     
/*      */     public Object read(ByteBuffer param1ByteBuffer, int param1Int) {
/*  523 */       return null;
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   static class BooleanType
/*      */     extends AutoDetectDataType
/*      */   {
/*      */     BooleanType(ObjectDataType param1ObjectDataType) {
/*  534 */       super(param1ObjectDataType, 1);
/*      */     }
/*      */ 
/*      */     
/*      */     public int compare(Object param1Object1, Object param1Object2) {
/*  539 */       if (param1Object1 instanceof Boolean && param1Object2 instanceof Boolean) {
/*  540 */         Boolean bool1 = (Boolean)param1Object1;
/*  541 */         Boolean bool2 = (Boolean)param1Object2;
/*  542 */         return bool1.compareTo(bool2);
/*      */       } 
/*  544 */       return super.compare(param1Object1, param1Object2);
/*      */     }
/*      */ 
/*      */     
/*      */     public int getMemory(Object param1Object) {
/*  549 */       return (param1Object instanceof Boolean) ? 0 : super.getMemory(param1Object);
/*      */     }
/*      */ 
/*      */     
/*      */     public void write(WriteBuffer param1WriteBuffer, Object param1Object) {
/*  554 */       if (!(param1Object instanceof Boolean)) {
/*  555 */         super.write(param1WriteBuffer, param1Object);
/*      */         return;
/*      */       } 
/*  558 */       boolean bool = ((Boolean)param1Object).booleanValue() ? true : true;
/*  559 */       param1WriteBuffer.put((byte)bool);
/*      */     }
/*      */ 
/*      */     
/*      */     public Object read(ByteBuffer param1ByteBuffer, int param1Int) {
/*  564 */       return (param1Int == 1) ? Boolean.FALSE : Boolean.TRUE;
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   static class ByteType
/*      */     extends AutoDetectDataType
/*      */   {
/*      */     ByteType(ObjectDataType param1ObjectDataType) {
/*  575 */       super(param1ObjectDataType, 2);
/*      */     }
/*      */ 
/*      */     
/*      */     public int compare(Object param1Object1, Object param1Object2) {
/*  580 */       if (param1Object1 instanceof Byte && param1Object2 instanceof Byte) {
/*  581 */         Byte byte_1 = (Byte)param1Object1;
/*  582 */         Byte byte_2 = (Byte)param1Object2;
/*  583 */         return byte_1.compareTo(byte_2);
/*      */       } 
/*  585 */       return super.compare(param1Object1, param1Object2);
/*      */     }
/*      */ 
/*      */     
/*      */     public int getMemory(Object param1Object) {
/*  590 */       return (param1Object instanceof Byte) ? 0 : super.getMemory(param1Object);
/*      */     }
/*      */ 
/*      */     
/*      */     public void write(WriteBuffer param1WriteBuffer, Object param1Object) {
/*  595 */       if (!(param1Object instanceof Byte)) {
/*  596 */         super.write(param1WriteBuffer, param1Object);
/*      */         return;
/*      */       } 
/*  599 */       param1WriteBuffer.put((byte)2);
/*  600 */       param1WriteBuffer.put(((Byte)param1Object).byteValue());
/*      */     }
/*      */ 
/*      */     
/*      */     public Object read(ByteBuffer param1ByteBuffer, int param1Int) {
/*  605 */       return Byte.valueOf(param1ByteBuffer.get());
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   static class CharacterType
/*      */     extends AutoDetectDataType
/*      */   {
/*      */     CharacterType(ObjectDataType param1ObjectDataType) {
/*  616 */       super(param1ObjectDataType, 10);
/*      */     }
/*      */ 
/*      */     
/*      */     public int compare(Object param1Object1, Object param1Object2) {
/*  621 */       if (param1Object1 instanceof Character && param1Object2 instanceof Character) {
/*  622 */         Character character1 = (Character)param1Object1;
/*  623 */         Character character2 = (Character)param1Object2;
/*  624 */         return character1.compareTo(character2);
/*      */       } 
/*  626 */       return super.compare(param1Object1, param1Object2);
/*      */     }
/*      */ 
/*      */     
/*      */     public int getMemory(Object param1Object) {
/*  631 */       return (param1Object instanceof Character) ? 24 : super.getMemory(param1Object);
/*      */     }
/*      */ 
/*      */     
/*      */     public void write(WriteBuffer param1WriteBuffer, Object param1Object) {
/*  636 */       if (!(param1Object instanceof Character)) {
/*  637 */         super.write(param1WriteBuffer, param1Object);
/*      */         return;
/*      */       } 
/*  640 */       param1WriteBuffer.put((byte)10);
/*  641 */       param1WriteBuffer.putChar(((Character)param1Object).charValue());
/*      */     }
/*      */ 
/*      */     
/*      */     public Object read(ByteBuffer param1ByteBuffer, int param1Int) {
/*  646 */       return Character.valueOf(param1ByteBuffer.getChar());
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   static class ShortType
/*      */     extends AutoDetectDataType
/*      */   {
/*      */     ShortType(ObjectDataType param1ObjectDataType) {
/*  657 */       super(param1ObjectDataType, 3);
/*      */     }
/*      */ 
/*      */     
/*      */     public int compare(Object param1Object1, Object param1Object2) {
/*  662 */       if (param1Object1 instanceof Short && param1Object2 instanceof Short) {
/*  663 */         Short short_1 = (Short)param1Object1;
/*  664 */         Short short_2 = (Short)param1Object2;
/*  665 */         return short_1.compareTo(short_2);
/*      */       } 
/*  667 */       return super.compare(param1Object1, param1Object2);
/*      */     }
/*      */ 
/*      */     
/*      */     public int getMemory(Object param1Object) {
/*  672 */       return (param1Object instanceof Short) ? 24 : super.getMemory(param1Object);
/*      */     }
/*      */ 
/*      */     
/*      */     public void write(WriteBuffer param1WriteBuffer, Object param1Object) {
/*  677 */       if (!(param1Object instanceof Short)) {
/*  678 */         super.write(param1WriteBuffer, param1Object);
/*      */         return;
/*      */       } 
/*  681 */       param1WriteBuffer.put((byte)3);
/*  682 */       param1WriteBuffer.putShort(((Short)param1Object).shortValue());
/*      */     }
/*      */ 
/*      */     
/*      */     public Object read(ByteBuffer param1ByteBuffer, int param1Int) {
/*  687 */       return Short.valueOf(param1ByteBuffer.getShort());
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   static class IntegerType
/*      */     extends AutoDetectDataType
/*      */   {
/*      */     IntegerType(ObjectDataType param1ObjectDataType) {
/*  698 */       super(param1ObjectDataType, 4);
/*      */     }
/*      */ 
/*      */     
/*      */     public int compare(Object param1Object1, Object param1Object2) {
/*  703 */       if (param1Object1 instanceof Integer && param1Object2 instanceof Integer) {
/*  704 */         Integer integer1 = (Integer)param1Object1;
/*  705 */         Integer integer2 = (Integer)param1Object2;
/*  706 */         return integer1.compareTo(integer2);
/*      */       } 
/*  708 */       return super.compare(param1Object1, param1Object2);
/*      */     }
/*      */ 
/*      */     
/*      */     public int getMemory(Object param1Object) {
/*  713 */       return (param1Object instanceof Integer) ? 24 : super.getMemory(param1Object);
/*      */     }
/*      */ 
/*      */     
/*      */     public void write(WriteBuffer param1WriteBuffer, Object param1Object) {
/*  718 */       if (!(param1Object instanceof Integer)) {
/*  719 */         super.write(param1WriteBuffer, param1Object);
/*      */         return;
/*      */       } 
/*  722 */       int i = ((Integer)param1Object).intValue();
/*  723 */       if (i < 0) {
/*      */         
/*  725 */         if (-i < 0 || -i > 2097151) {
/*  726 */           param1WriteBuffer.put((byte)34).putInt(i);
/*      */         } else {
/*  728 */           param1WriteBuffer.put((byte)33).putVarInt(-i);
/*      */         } 
/*  730 */       } else if (i <= 15) {
/*  731 */         param1WriteBuffer.put((byte)(64 + i));
/*  732 */       } else if (i <= 2097151) {
/*  733 */         param1WriteBuffer.put((byte)4).putVarInt(i);
/*      */       } else {
/*  735 */         param1WriteBuffer.put((byte)34).putInt(i);
/*      */       } 
/*      */     }
/*      */ 
/*      */     
/*      */     public Object read(ByteBuffer param1ByteBuffer, int param1Int) {
/*  741 */       switch (param1Int) {
/*      */         case 4:
/*  743 */           return Integer.valueOf(DataUtils.readVarInt(param1ByteBuffer));
/*      */         case 33:
/*  745 */           return Integer.valueOf(-DataUtils.readVarInt(param1ByteBuffer));
/*      */         case 34:
/*  747 */           return Integer.valueOf(param1ByteBuffer.getInt());
/*      */       } 
/*  749 */       return Integer.valueOf(param1Int - 64);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   static class LongType
/*      */     extends AutoDetectDataType
/*      */   {
/*      */     LongType(ObjectDataType param1ObjectDataType) {
/*  760 */       super(param1ObjectDataType, 5);
/*      */     }
/*      */ 
/*      */     
/*      */     public int compare(Object param1Object1, Object param1Object2) {
/*  765 */       if (param1Object1 instanceof Long && param1Object2 instanceof Long) {
/*  766 */         Long long_1 = (Long)param1Object1;
/*  767 */         Long long_2 = (Long)param1Object2;
/*  768 */         return long_1.compareTo(long_2);
/*      */       } 
/*  770 */       return super.compare(param1Object1, param1Object2);
/*      */     }
/*      */ 
/*      */     
/*      */     public int getMemory(Object param1Object) {
/*  775 */       return (param1Object instanceof Long) ? 30 : super.getMemory(param1Object);
/*      */     }
/*      */ 
/*      */     
/*      */     public void write(WriteBuffer param1WriteBuffer, Object param1Object) {
/*  780 */       if (!(param1Object instanceof Long)) {
/*  781 */         super.write(param1WriteBuffer, param1Object);
/*      */         return;
/*      */       } 
/*  784 */       long l = ((Long)param1Object).longValue();
/*  785 */       if (l < 0L) {
/*      */         
/*  787 */         if (-l < 0L || -l > 562949953421311L) {
/*  788 */           param1WriteBuffer.put((byte)36);
/*  789 */           param1WriteBuffer.putLong(l);
/*      */         } else {
/*  791 */           param1WriteBuffer.put((byte)35);
/*  792 */           param1WriteBuffer.putVarLong(-l);
/*      */         } 
/*  794 */       } else if (l <= 7L) {
/*  795 */         param1WriteBuffer.put((byte)(int)(80L + l));
/*  796 */       } else if (l <= 562949953421311L) {
/*  797 */         param1WriteBuffer.put((byte)5);
/*  798 */         param1WriteBuffer.putVarLong(l);
/*      */       } else {
/*  800 */         param1WriteBuffer.put((byte)36);
/*  801 */         param1WriteBuffer.putLong(l);
/*      */       } 
/*      */     }
/*      */ 
/*      */     
/*      */     public Object read(ByteBuffer param1ByteBuffer, int param1Int) {
/*  807 */       switch (param1Int) {
/*      */         case 5:
/*  809 */           return Long.valueOf(DataUtils.readVarLong(param1ByteBuffer));
/*      */         case 35:
/*  811 */           return Long.valueOf(-DataUtils.readVarLong(param1ByteBuffer));
/*      */         case 36:
/*  813 */           return Long.valueOf(param1ByteBuffer.getLong());
/*      */       } 
/*  815 */       return Long.valueOf((param1Int - 80));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   static class FloatType
/*      */     extends AutoDetectDataType
/*      */   {
/*      */     FloatType(ObjectDataType param1ObjectDataType) {
/*  826 */       super(param1ObjectDataType, 7);
/*      */     }
/*      */ 
/*      */     
/*      */     public int compare(Object param1Object1, Object param1Object2) {
/*  831 */       if (param1Object1 instanceof Float && param1Object2 instanceof Float) {
/*  832 */         Float float_1 = (Float)param1Object1;
/*  833 */         Float float_2 = (Float)param1Object2;
/*  834 */         return float_1.compareTo(float_2);
/*      */       } 
/*  836 */       return super.compare(param1Object1, param1Object2);
/*      */     }
/*      */ 
/*      */     
/*      */     public int getMemory(Object param1Object) {
/*  841 */       return (param1Object instanceof Float) ? 24 : super.getMemory(param1Object);
/*      */     }
/*      */ 
/*      */     
/*      */     public void write(WriteBuffer param1WriteBuffer, Object param1Object) {
/*  846 */       if (!(param1Object instanceof Float)) {
/*  847 */         super.write(param1WriteBuffer, param1Object);
/*      */         return;
/*      */       } 
/*  850 */       float f = ((Float)param1Object).floatValue();
/*  851 */       int i = Float.floatToIntBits(f);
/*  852 */       if (i == ObjectDataType.FLOAT_ZERO_BITS) {
/*  853 */         param1WriteBuffer.put((byte)40);
/*  854 */       } else if (i == ObjectDataType.FLOAT_ONE_BITS) {
/*  855 */         param1WriteBuffer.put((byte)41);
/*      */       } else {
/*  857 */         int j = Integer.reverse(i);
/*  858 */         if (j >= 0 && j <= 2097151) {
/*  859 */           param1WriteBuffer.put((byte)7).putVarInt(j);
/*      */         } else {
/*  861 */           param1WriteBuffer.put((byte)42).putFloat(f);
/*      */         } 
/*      */       } 
/*      */     }
/*      */ 
/*      */     
/*      */     public Object read(ByteBuffer param1ByteBuffer, int param1Int) {
/*  868 */       switch (param1Int) {
/*      */         case 40:
/*  870 */           return Float.valueOf(0.0F);
/*      */         case 41:
/*  872 */           return Float.valueOf(1.0F);
/*      */         case 42:
/*  874 */           return Float.valueOf(param1ByteBuffer.getFloat());
/*      */       } 
/*  876 */       return Float.valueOf(Float.intBitsToFloat(Integer.reverse(DataUtils.readVarInt(param1ByteBuffer))));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   static class DoubleType
/*      */     extends AutoDetectDataType
/*      */   {
/*      */     DoubleType(ObjectDataType param1ObjectDataType) {
/*  888 */       super(param1ObjectDataType, 8);
/*      */     }
/*      */ 
/*      */     
/*      */     public int compare(Object param1Object1, Object param1Object2) {
/*  893 */       if (param1Object1 instanceof Double && param1Object2 instanceof Double) {
/*  894 */         Double double_1 = (Double)param1Object1;
/*  895 */         Double double_2 = (Double)param1Object2;
/*  896 */         return double_1.compareTo(double_2);
/*      */       } 
/*  898 */       return super.compare(param1Object1, param1Object2);
/*      */     }
/*      */ 
/*      */     
/*      */     public int getMemory(Object param1Object) {
/*  903 */       return (param1Object instanceof Double) ? 30 : super.getMemory(param1Object);
/*      */     }
/*      */ 
/*      */     
/*      */     public void write(WriteBuffer param1WriteBuffer, Object param1Object) {
/*  908 */       if (!(param1Object instanceof Double)) {
/*  909 */         super.write(param1WriteBuffer, param1Object);
/*      */         return;
/*      */       } 
/*  912 */       double d = ((Double)param1Object).doubleValue();
/*  913 */       long l = Double.doubleToLongBits(d);
/*  914 */       if (l == ObjectDataType.DOUBLE_ZERO_BITS) {
/*  915 */         param1WriteBuffer.put((byte)43);
/*  916 */       } else if (l == ObjectDataType.DOUBLE_ONE_BITS) {
/*  917 */         param1WriteBuffer.put((byte)44);
/*      */       } else {
/*  919 */         long l1 = Long.reverse(l);
/*  920 */         if (l1 >= 0L && l1 <= 562949953421311L) {
/*  921 */           param1WriteBuffer.put((byte)8);
/*  922 */           param1WriteBuffer.putVarLong(l1);
/*      */         } else {
/*  924 */           param1WriteBuffer.put((byte)45);
/*  925 */           param1WriteBuffer.putDouble(d);
/*      */         } 
/*      */       } 
/*      */     }
/*      */ 
/*      */     
/*      */     public Object read(ByteBuffer param1ByteBuffer, int param1Int) {
/*  932 */       switch (param1Int) {
/*      */         case 43:
/*  934 */           return Double.valueOf(0.0D);
/*      */         case 44:
/*  936 */           return Double.valueOf(1.0D);
/*      */         case 45:
/*  938 */           return Double.valueOf(param1ByteBuffer.getDouble());
/*      */       } 
/*  940 */       return Double.valueOf(Double.longBitsToDouble(Long.reverse(DataUtils.readVarLong(param1ByteBuffer))));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   static class BigIntegerType
/*      */     extends AutoDetectDataType
/*      */   {
/*      */     BigIntegerType(ObjectDataType param1ObjectDataType) {
/*  952 */       super(param1ObjectDataType, 6);
/*      */     }
/*      */ 
/*      */     
/*      */     public int compare(Object param1Object1, Object param1Object2) {
/*  957 */       if (ObjectDataType.isBigInteger(param1Object1) && ObjectDataType.isBigInteger(param1Object2)) {
/*  958 */         BigInteger bigInteger1 = (BigInteger)param1Object1;
/*  959 */         BigInteger bigInteger2 = (BigInteger)param1Object2;
/*  960 */         return bigInteger1.compareTo(bigInteger2);
/*      */       } 
/*  962 */       return super.compare(param1Object1, param1Object2);
/*      */     }
/*      */ 
/*      */     
/*      */     public int getMemory(Object param1Object) {
/*  967 */       return ObjectDataType.isBigInteger(param1Object) ? 100 : super.getMemory(param1Object);
/*      */     }
/*      */ 
/*      */     
/*      */     public void write(WriteBuffer param1WriteBuffer, Object param1Object) {
/*  972 */       if (!ObjectDataType.isBigInteger(param1Object)) {
/*  973 */         super.write(param1WriteBuffer, param1Object);
/*      */         return;
/*      */       } 
/*  976 */       BigInteger bigInteger = (BigInteger)param1Object;
/*  977 */       if (BigInteger.ZERO.equals(bigInteger)) {
/*  978 */         param1WriteBuffer.put((byte)37);
/*  979 */       } else if (BigInteger.ONE.equals(bigInteger)) {
/*  980 */         param1WriteBuffer.put((byte)38);
/*      */       } else {
/*  982 */         int i = bigInteger.bitLength();
/*  983 */         if (i <= 63) {
/*  984 */           param1WriteBuffer.put((byte)39).putVarLong(bigInteger.longValue());
/*      */         } else {
/*      */           
/*  987 */           byte[] arrayOfByte = bigInteger.toByteArray();
/*  988 */           param1WriteBuffer.put((byte)6).putVarInt(arrayOfByte.length).put(arrayOfByte);
/*      */         } 
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public Object read(ByteBuffer param1ByteBuffer, int param1Int) {
/*  996 */       switch (param1Int) {
/*      */         case 37:
/*  998 */           return BigInteger.ZERO;
/*      */         case 38:
/* 1000 */           return BigInteger.ONE;
/*      */         case 39:
/* 1002 */           return BigInteger.valueOf(DataUtils.readVarLong(param1ByteBuffer));
/*      */       } 
/* 1004 */       int i = DataUtils.readVarInt(param1ByteBuffer);
/* 1005 */       byte[] arrayOfByte = DataUtils.newBytes(i);
/* 1006 */       param1ByteBuffer.get(arrayOfByte);
/* 1007 */       return new BigInteger(arrayOfByte);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   static class BigDecimalType
/*      */     extends AutoDetectDataType
/*      */   {
/*      */     BigDecimalType(ObjectDataType param1ObjectDataType) {
/* 1018 */       super(param1ObjectDataType, 9);
/*      */     }
/*      */ 
/*      */     
/*      */     public int compare(Object param1Object1, Object param1Object2) {
/* 1023 */       if (ObjectDataType.isBigDecimal(param1Object1) && ObjectDataType.isBigDecimal(param1Object2)) {
/* 1024 */         BigDecimal bigDecimal1 = (BigDecimal)param1Object1;
/* 1025 */         BigDecimal bigDecimal2 = (BigDecimal)param1Object2;
/* 1026 */         return bigDecimal1.compareTo(bigDecimal2);
/*      */       } 
/* 1028 */       return super.compare(param1Object1, param1Object2);
/*      */     }
/*      */ 
/*      */     
/*      */     public int getMemory(Object param1Object) {
/* 1033 */       return ObjectDataType.isBigDecimal(param1Object) ? 150 : super.getMemory(param1Object);
/*      */     }
/*      */ 
/*      */     
/*      */     public void write(WriteBuffer param1WriteBuffer, Object param1Object) {
/* 1038 */       if (!ObjectDataType.isBigDecimal(param1Object)) {
/* 1039 */         super.write(param1WriteBuffer, param1Object);
/*      */         return;
/*      */       } 
/* 1042 */       BigDecimal bigDecimal = (BigDecimal)param1Object;
/* 1043 */       if (BigDecimal.ZERO.equals(bigDecimal)) {
/* 1044 */         param1WriteBuffer.put((byte)46);
/* 1045 */       } else if (BigDecimal.ONE.equals(bigDecimal)) {
/* 1046 */         param1WriteBuffer.put((byte)47);
/*      */       } else {
/* 1048 */         int i = bigDecimal.scale();
/* 1049 */         BigInteger bigInteger = bigDecimal.unscaledValue();
/* 1050 */         int j = bigInteger.bitLength();
/* 1051 */         if (j < 64) {
/* 1052 */           if (i == 0) {
/* 1053 */             param1WriteBuffer.put((byte)48);
/*      */           } else {
/* 1055 */             param1WriteBuffer.put((byte)49).putVarInt(i);
/*      */           } 
/*      */           
/* 1058 */           param1WriteBuffer.putVarLong(bigInteger.longValue());
/*      */         } else {
/* 1060 */           byte[] arrayOfByte = bigInteger.toByteArray();
/* 1061 */           param1WriteBuffer.put((byte)9).putVarInt(i).putVarInt(arrayOfByte.length).put(arrayOfByte);
/*      */         } 
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public Object read(ByteBuffer param1ByteBuffer, int param1Int) {
/* 1069 */       switch (param1Int) {
/*      */         case 46:
/* 1071 */           return BigDecimal.ZERO;
/*      */         case 47:
/* 1073 */           return BigDecimal.ONE;
/*      */         case 48:
/* 1075 */           return BigDecimal.valueOf(DataUtils.readVarLong(param1ByteBuffer));
/*      */         case 49:
/* 1077 */           i = DataUtils.readVarInt(param1ByteBuffer);
/* 1078 */           return BigDecimal.valueOf(DataUtils.readVarLong(param1ByteBuffer), i);
/*      */       } 
/* 1080 */       int i = DataUtils.readVarInt(param1ByteBuffer);
/* 1081 */       int j = DataUtils.readVarInt(param1ByteBuffer);
/* 1082 */       byte[] arrayOfByte = DataUtils.newBytes(j);
/* 1083 */       param1ByteBuffer.get(arrayOfByte);
/* 1084 */       BigInteger bigInteger = new BigInteger(arrayOfByte);
/* 1085 */       return new BigDecimal(bigInteger, i);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   static class StringType
/*      */     extends AutoDetectDataType
/*      */   {
/*      */     StringType(ObjectDataType param1ObjectDataType) {
/* 1096 */       super(param1ObjectDataType, 11);
/*      */     }
/*      */ 
/*      */     
/*      */     public int getMemory(Object param1Object) {
/* 1101 */       if (!(param1Object instanceof String)) {
/* 1102 */         return super.getMemory(param1Object);
/*      */       }
/* 1104 */       return 24 + 2 * param1Object.toString().length();
/*      */     }
/*      */ 
/*      */     
/*      */     public int compare(Object param1Object1, Object param1Object2) {
/* 1109 */       if (param1Object1 instanceof String && param1Object2 instanceof String) {
/* 1110 */         return param1Object1.toString().compareTo(param1Object2.toString());
/*      */       }
/* 1112 */       return super.compare(param1Object1, param1Object2);
/*      */     }
/*      */ 
/*      */     
/*      */     public void write(WriteBuffer param1WriteBuffer, Object param1Object) {
/* 1117 */       if (!(param1Object instanceof String)) {
/* 1118 */         super.write(param1WriteBuffer, param1Object);
/*      */         return;
/*      */       } 
/* 1121 */       String str = (String)param1Object;
/* 1122 */       int i = str.length();
/* 1123 */       if (i <= 15) {
/* 1124 */         param1WriteBuffer.put((byte)(88 + i));
/*      */       } else {
/* 1126 */         param1WriteBuffer.put((byte)11).putVarInt(i);
/*      */       } 
/* 1128 */       param1WriteBuffer.putStringData(str, i);
/*      */     }
/*      */ 
/*      */     
/*      */     public Object read(ByteBuffer param1ByteBuffer, int param1Int) {
/*      */       int i;
/* 1134 */       if (param1Int == 11) {
/* 1135 */         i = DataUtils.readVarInt(param1ByteBuffer);
/*      */       } else {
/* 1137 */         i = param1Int - 88;
/*      */       } 
/* 1139 */       return DataUtils.readString(param1ByteBuffer, i);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   static class UUIDType
/*      */     extends AutoDetectDataType
/*      */   {
/*      */     UUIDType(ObjectDataType param1ObjectDataType) {
/* 1150 */       super(param1ObjectDataType, 12);
/*      */     }
/*      */ 
/*      */     
/*      */     public int getMemory(Object param1Object) {
/* 1155 */       return (param1Object instanceof UUID) ? 40 : super.getMemory(param1Object);
/*      */     }
/*      */ 
/*      */     
/*      */     public int compare(Object param1Object1, Object param1Object2) {
/* 1160 */       if (param1Object1 instanceof UUID && param1Object2 instanceof UUID) {
/* 1161 */         UUID uUID1 = (UUID)param1Object1;
/* 1162 */         UUID uUID2 = (UUID)param1Object2;
/* 1163 */         return uUID1.compareTo(uUID2);
/*      */       } 
/* 1165 */       return super.compare(param1Object1, param1Object2);
/*      */     }
/*      */ 
/*      */     
/*      */     public void write(WriteBuffer param1WriteBuffer, Object param1Object) {
/* 1170 */       if (!(param1Object instanceof UUID)) {
/* 1171 */         super.write(param1WriteBuffer, param1Object);
/*      */         return;
/*      */       } 
/* 1174 */       param1WriteBuffer.put((byte)12);
/* 1175 */       UUID uUID = (UUID)param1Object;
/* 1176 */       param1WriteBuffer.putLong(uUID.getMostSignificantBits());
/* 1177 */       param1WriteBuffer.putLong(uUID.getLeastSignificantBits());
/*      */     }
/*      */ 
/*      */     
/*      */     public Object read(ByteBuffer param1ByteBuffer, int param1Int) {
/* 1182 */       long l1 = param1ByteBuffer.getLong(), l2 = param1ByteBuffer.getLong();
/* 1183 */       return new UUID(l1, l2);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   static class DateType
/*      */     extends AutoDetectDataType
/*      */   {
/*      */     DateType(ObjectDataType param1ObjectDataType) {
/* 1194 */       super(param1ObjectDataType, 13);
/*      */     }
/*      */ 
/*      */     
/*      */     public int getMemory(Object param1Object) {
/* 1199 */       return ObjectDataType.isDate(param1Object) ? 40 : super.getMemory(param1Object);
/*      */     }
/*      */ 
/*      */     
/*      */     public int compare(Object param1Object1, Object param1Object2) {
/* 1204 */       if (ObjectDataType.isDate(param1Object1) && ObjectDataType.isDate(param1Object2)) {
/* 1205 */         Date date1 = (Date)param1Object1;
/* 1206 */         Date date2 = (Date)param1Object2;
/* 1207 */         return date1.compareTo(date2);
/*      */       } 
/* 1209 */       return super.compare(param1Object1, param1Object2);
/*      */     }
/*      */ 
/*      */     
/*      */     public void write(WriteBuffer param1WriteBuffer, Object param1Object) {
/* 1214 */       if (!ObjectDataType.isDate(param1Object)) {
/* 1215 */         super.write(param1WriteBuffer, param1Object);
/*      */         return;
/*      */       } 
/* 1218 */       param1WriteBuffer.put((byte)13);
/* 1219 */       Date date = (Date)param1Object;
/* 1220 */       param1WriteBuffer.putLong(date.getTime());
/*      */     }
/*      */ 
/*      */     
/*      */     public Object read(ByteBuffer param1ByteBuffer, int param1Int) {
/* 1225 */       long l = param1ByteBuffer.getLong();
/* 1226 */       return new Date(l);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   static class ObjectArrayType
/*      */     extends AutoDetectDataType
/*      */   {
/* 1236 */     private final ObjectDataType elementType = new ObjectDataType();
/*      */     
/*      */     ObjectArrayType(ObjectDataType param1ObjectDataType) {
/* 1239 */       super(param1ObjectDataType, 14);
/*      */     }
/*      */ 
/*      */     
/*      */     public int getMemory(Object param1Object) {
/* 1244 */       if (!ObjectDataType.isArray(param1Object)) {
/* 1245 */         return super.getMemory(param1Object);
/*      */       }
/* 1247 */       int i = 64;
/* 1248 */       Class<?> clazz = param1Object.getClass().getComponentType();
/* 1249 */       if (clazz.isPrimitive()) {
/* 1250 */         int j = Array.getLength(param1Object);
/* 1251 */         if (clazz == boolean.class) {
/* 1252 */           i += j;
/* 1253 */         } else if (clazz == byte.class) {
/* 1254 */           i += j;
/* 1255 */         } else if (clazz == char.class) {
/* 1256 */           i += j * 2;
/* 1257 */         } else if (clazz == short.class) {
/* 1258 */           i += j * 2;
/* 1259 */         } else if (clazz == int.class) {
/* 1260 */           i += j * 4;
/* 1261 */         } else if (clazz == float.class) {
/* 1262 */           i += j * 4;
/* 1263 */         } else if (clazz == double.class) {
/* 1264 */           i += j * 8;
/* 1265 */         } else if (clazz == long.class) {
/* 1266 */           i += j * 8;
/*      */         } 
/*      */       } else {
/* 1269 */         for (Object object : (Object[])param1Object) {
/* 1270 */           if (object != null) {
/* 1271 */             i += this.elementType.getMemory(object);
/*      */           }
/*      */         } 
/*      */       } 
/*      */ 
/*      */       
/* 1277 */       return i * 2;
/*      */     }
/*      */ 
/*      */     
/*      */     public int compare(Object param1Object1, Object param1Object2) {
/* 1282 */       if (!ObjectDataType.isArray(param1Object1) || !ObjectDataType.isArray(param1Object2)) {
/* 1283 */         return super.compare(param1Object1, param1Object2);
/*      */       }
/* 1285 */       if (param1Object1 == param1Object2) {
/* 1286 */         return 0;
/*      */       }
/* 1288 */       Class<?> clazz1 = param1Object1.getClass().getComponentType();
/* 1289 */       Class<?> clazz2 = param1Object2.getClass().getComponentType();
/* 1290 */       if (clazz1 != clazz2) {
/* 1291 */         Integer integer1 = ObjectDataType.getCommonClassId(clazz1);
/* 1292 */         Integer integer2 = ObjectDataType.getCommonClassId(clazz2);
/* 1293 */         if (integer1 != null) {
/* 1294 */           if (integer2 != null) {
/* 1295 */             return integer1.compareTo(integer2);
/*      */           }
/* 1297 */           return -1;
/* 1298 */         }  if (integer2 != null) {
/* 1299 */           return 1;
/*      */         }
/* 1301 */         return clazz1.getName().compareTo(clazz2.getName());
/*      */       } 
/* 1303 */       int i = Array.getLength(param1Object1);
/* 1304 */       int j = Array.getLength(param1Object2);
/* 1305 */       int k = Math.min(i, j);
/* 1306 */       if (clazz1.isPrimitive()) {
/* 1307 */         if (clazz1 == byte.class) {
/* 1308 */           byte[] arrayOfByte1 = (byte[])param1Object1;
/* 1309 */           byte[] arrayOfByte2 = (byte[])param1Object2;
/* 1310 */           return ObjectDataType.compareNotNull(arrayOfByte1, arrayOfByte2);
/*      */         } 
/* 1312 */         for (byte b = 0; b < k; b++) {
/*      */           boolean bool;
/* 1314 */           if (clazz1 == boolean.class) {
/* 1315 */             bool = Integer.signum((((boolean[])param1Object1)[b] ? 1 : 0) - (((boolean[])param1Object2)[b] ? 1 : 0));
/*      */           }
/* 1317 */           else if (clazz1 == char.class) {
/* 1318 */             bool = Integer.signum(((char[])param1Object1)[b] - ((char[])param1Object2)[b]);
/*      */           }
/* 1320 */           else if (clazz1 == short.class) {
/* 1321 */             bool = Integer.signum(((short[])param1Object1)[b] - ((short[])param1Object2)[b]);
/*      */           }
/* 1323 */           else if (clazz1 == int.class) {
/* 1324 */             int m = ((int[])param1Object1)[b];
/* 1325 */             int n = ((int[])param1Object2)[b];
/* 1326 */             bool = (m == n) ? false : ((m < n) ? true : true);
/* 1327 */           } else if (clazz1 == float.class) {
/* 1328 */             bool = Float.compare(((float[])param1Object1)[b], ((float[])param1Object2)[b]);
/*      */           }
/* 1330 */           else if (clazz1 == double.class) {
/* 1331 */             bool = Double.compare(((double[])param1Object1)[b], ((double[])param1Object2)[b]);
/*      */           } else {
/*      */             
/* 1334 */             long l1 = ((long[])param1Object1)[b];
/* 1335 */             long l2 = ((long[])param1Object2)[b];
/* 1336 */             bool = (l1 == l2) ? false : ((l1 < l2) ? true : true);
/*      */           } 
/* 1338 */           if (bool) {
/* 1339 */             return bool;
/*      */           }
/*      */         } 
/*      */       } else {
/* 1343 */         Object[] arrayOfObject1 = (Object[])param1Object1;
/* 1344 */         Object[] arrayOfObject2 = (Object[])param1Object2;
/* 1345 */         for (byte b = 0; b < k; b++) {
/* 1346 */           int m = this.elementType.compare(arrayOfObject1[b], arrayOfObject2[b]);
/* 1347 */           if (m != 0) {
/* 1348 */             return m;
/*      */           }
/*      */         } 
/*      */       } 
/* 1352 */       return (i == j) ? 0 : ((i < j) ? -1 : 1);
/*      */     }
/*      */ 
/*      */     
/*      */     public void write(WriteBuffer param1WriteBuffer, Object param1Object) {
/* 1357 */       if (!ObjectDataType.isArray(param1Object)) {
/* 1358 */         super.write(param1WriteBuffer, param1Object);
/*      */         return;
/*      */       } 
/* 1361 */       Class<?> clazz = param1Object.getClass().getComponentType();
/* 1362 */       Integer integer = ObjectDataType.getCommonClassId(clazz);
/* 1363 */       if (integer != null) {
/* 1364 */         if (clazz.isPrimitive()) {
/* 1365 */           if (clazz == byte.class) {
/* 1366 */             byte[] arrayOfByte = (byte[])param1Object;
/* 1367 */             int k = arrayOfByte.length;
/* 1368 */             if (k <= 15) {
/* 1369 */               param1WriteBuffer.put((byte)(104 + k));
/*      */             } else {
/* 1371 */               param1WriteBuffer.put((byte)14).put((byte)integer.intValue()).putVarInt(k);
/*      */             } 
/*      */ 
/*      */             
/* 1375 */             param1WriteBuffer.put(arrayOfByte);
/*      */             return;
/*      */           } 
/* 1378 */           int j = Array.getLength(param1Object);
/* 1379 */           param1WriteBuffer.put((byte)14).put((byte)integer.intValue()).putVarInt(j);
/*      */           
/* 1381 */           for (byte b = 0; b < j; b++) {
/* 1382 */             if (clazz == boolean.class) {
/* 1383 */               param1WriteBuffer.put((byte)(((boolean[])param1Object)[b] ? 1 : 0));
/* 1384 */             } else if (clazz == char.class) {
/* 1385 */               param1WriteBuffer.putChar(((char[])param1Object)[b]);
/* 1386 */             } else if (clazz == short.class) {
/* 1387 */               param1WriteBuffer.putShort(((short[])param1Object)[b]);
/* 1388 */             } else if (clazz == int.class) {
/* 1389 */               param1WriteBuffer.putInt(((int[])param1Object)[b]);
/* 1390 */             } else if (clazz == float.class) {
/* 1391 */               param1WriteBuffer.putFloat(((float[])param1Object)[b]);
/* 1392 */             } else if (clazz == double.class) {
/* 1393 */               param1WriteBuffer.putDouble(((double[])param1Object)[b]);
/*      */             } else {
/* 1395 */               param1WriteBuffer.putLong(((long[])param1Object)[b]);
/*      */             } 
/*      */           } 
/*      */           return;
/*      */         } 
/* 1400 */         param1WriteBuffer.put((byte)14).put((byte)integer.intValue());
/*      */       } else {
/* 1402 */         param1WriteBuffer.put((byte)14).put((byte)-1);
/* 1403 */         String str = clazz.getName();
/* 1404 */         StringDataType.INSTANCE.write(param1WriteBuffer, str);
/*      */       } 
/* 1406 */       Object[] arrayOfObject = (Object[])param1Object;
/* 1407 */       int i = arrayOfObject.length;
/* 1408 */       param1WriteBuffer.putVarInt(i);
/* 1409 */       for (Object object : arrayOfObject)
/* 1410 */         this.elementType.write(param1WriteBuffer, object); 
/*      */     }
/*      */     
/*      */     public Object read(ByteBuffer param1ByteBuffer, int param1Int) {
/*      */       Class<?> clazz;
/*      */       Object object;
/* 1416 */       if (param1Int != 14) {
/*      */         
/* 1418 */         int j = param1Int - 104;
/* 1419 */         byte[] arrayOfByte = DataUtils.newBytes(j);
/* 1420 */         param1ByteBuffer.get(arrayOfByte);
/* 1421 */         return arrayOfByte;
/*      */       } 
/* 1423 */       byte b = param1ByteBuffer.get();
/*      */ 
/*      */       
/* 1426 */       if (b == -1) {
/* 1427 */         String str = StringDataType.INSTANCE.read(param1ByteBuffer);
/*      */         try {
/* 1429 */           clazz = Class.forName(str);
/* 1430 */         } catch (Exception exception) {
/* 1431 */           throw DataUtils.newIllegalStateException(8, "Could not get class {0}", new Object[] { str, exception });
/*      */         }
/*      */       
/*      */       } else {
/*      */         
/* 1436 */         clazz = ObjectDataType.COMMON_CLASSES[b];
/*      */       } 
/* 1438 */       int i = DataUtils.readVarInt(param1ByteBuffer);
/*      */       try {
/* 1440 */         object = Array.newInstance(clazz, i);
/* 1441 */       } catch (Exception exception) {
/* 1442 */         throw DataUtils.newIllegalStateException(8, "Could not create array of type {0} length {1}", new Object[] { clazz, Integer.valueOf(i), exception });
/*      */       } 
/*      */ 
/*      */ 
/*      */       
/* 1447 */       if (clazz.isPrimitive()) {
/* 1448 */         for (byte b1 = 0; b1 < i; b1++) {
/* 1449 */           if (clazz == boolean.class) {
/* 1450 */             ((boolean[])object)[b1] = (param1ByteBuffer.get() == 1);
/* 1451 */           } else if (clazz == byte.class) {
/* 1452 */             ((byte[])object)[b1] = param1ByteBuffer.get();
/* 1453 */           } else if (clazz == char.class) {
/* 1454 */             ((char[])object)[b1] = param1ByteBuffer.getChar();
/* 1455 */           } else if (clazz == short.class) {
/* 1456 */             ((short[])object)[b1] = param1ByteBuffer.getShort();
/* 1457 */           } else if (clazz == int.class) {
/* 1458 */             ((int[])object)[b1] = param1ByteBuffer.getInt();
/* 1459 */           } else if (clazz == float.class) {
/* 1460 */             ((float[])object)[b1] = param1ByteBuffer.getFloat();
/* 1461 */           } else if (clazz == double.class) {
/* 1462 */             ((double[])object)[b1] = param1ByteBuffer.getDouble();
/*      */           } else {
/* 1464 */             ((long[])object)[b1] = param1ByteBuffer.getLong();
/*      */           } 
/*      */         } 
/*      */       } else {
/* 1468 */         Object[] arrayOfObject = (Object[])object;
/* 1469 */         for (byte b1 = 0; b1 < i; b1++) {
/* 1470 */           arrayOfObject[b1] = this.elementType.read(param1ByteBuffer);
/*      */         }
/*      */       } 
/* 1473 */       return object;
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   static class SerializedObjectType
/*      */     extends AutoDetectDataType
/*      */   {
/* 1483 */     private int averageSize = 10000;
/*      */     
/*      */     SerializedObjectType(ObjectDataType param1ObjectDataType) {
/* 1486 */       super(param1ObjectDataType, 19);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public int compare(Object param1Object1, Object param1Object2) {
/* 1492 */       if (param1Object1 == param1Object2) {
/* 1493 */         return 0;
/*      */       }
/* 1495 */       ObjectDataType.AutoDetectDataType autoDetectDataType1 = getType(param1Object1);
/* 1496 */       ObjectDataType.AutoDetectDataType autoDetectDataType2 = getType(param1Object2);
/* 1497 */       if (autoDetectDataType1 != this || autoDetectDataType2 != this) {
/* 1498 */         if (autoDetectDataType1 == autoDetectDataType2) {
/* 1499 */           return autoDetectDataType1.compare(param1Object1, param1Object2);
/*      */         }
/* 1501 */         return super.compare(param1Object1, param1Object2);
/*      */       } 
/*      */ 
/*      */       
/* 1505 */       if (param1Object1 instanceof Comparable && 
/* 1506 */         param1Object1.getClass().isAssignableFrom(param1Object2.getClass())) {
/* 1507 */         return ((Comparable<Object>)param1Object1).compareTo(param1Object2);
/*      */       }
/*      */       
/* 1510 */       if (param1Object2 instanceof Comparable && 
/* 1511 */         param1Object2.getClass().isAssignableFrom(param1Object1.getClass())) {
/* 1512 */         return -((Comparable)param1Object2).compareTo((T)param1Object1);
/*      */       }
/*      */       
/* 1515 */       byte[] arrayOfByte1 = ObjectDataType.serialize(param1Object1);
/* 1516 */       byte[] arrayOfByte2 = ObjectDataType.serialize(param1Object2);
/* 1517 */       return ObjectDataType.compareNotNull(arrayOfByte1, arrayOfByte2);
/*      */     }
/*      */ 
/*      */     
/*      */     public int getMemory(Object param1Object) {
/* 1522 */       ObjectDataType.AutoDetectDataType autoDetectDataType = getType(param1Object);
/* 1523 */       if (autoDetectDataType == this) {
/* 1524 */         return this.averageSize;
/*      */       }
/* 1526 */       return autoDetectDataType.getMemory(param1Object);
/*      */     }
/*      */ 
/*      */     
/*      */     public void write(WriteBuffer param1WriteBuffer, Object param1Object) {
/* 1531 */       ObjectDataType.AutoDetectDataType autoDetectDataType = getType(param1Object);
/* 1532 */       if (autoDetectDataType != this) {
/* 1533 */         autoDetectDataType.write(param1WriteBuffer, param1Object);
/*      */         return;
/*      */       } 
/* 1536 */       byte[] arrayOfByte = ObjectDataType.serialize(param1Object);
/*      */ 
/*      */       
/* 1539 */       int i = arrayOfByte.length * 2;
/*      */ 
/*      */       
/* 1542 */       this.averageSize = (i + 15 * this.averageSize) / 16;
/* 1543 */       param1WriteBuffer.put((byte)19).putVarInt(arrayOfByte.length).put(arrayOfByte);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public Object read(ByteBuffer param1ByteBuffer, int param1Int) {
/* 1549 */       int i = DataUtils.readVarInt(param1ByteBuffer);
/* 1550 */       byte[] arrayOfByte = DataUtils.newBytes(i);
/* 1551 */       param1ByteBuffer.get(arrayOfByte);
/* 1552 */       return ObjectDataType.deserialize(arrayOfByte);
/*      */     }
/*      */   }
/*      */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\mvstore\type\ObjectDataType.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */