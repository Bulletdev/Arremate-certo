/*      */ package com.sun.jna;
/*      */ 
/*      */ import java.lang.annotation.Documented;
/*      */ import java.lang.annotation.ElementType;
/*      */ import java.lang.annotation.Retention;
/*      */ import java.lang.annotation.RetentionPolicy;
/*      */ import java.lang.annotation.Target;
/*      */ import java.lang.reflect.Array;
/*      */ import java.lang.reflect.Constructor;
/*      */ import java.lang.reflect.Field;
/*      */ import java.lang.reflect.InvocationTargetException;
/*      */ import java.lang.reflect.Modifier;
/*      */ import java.nio.Buffer;
/*      */ import java.util.AbstractCollection;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Arrays;
/*      */ import java.util.Collection;
/*      */ import java.util.Collections;
/*      */ import java.util.HashMap;
/*      */ import java.util.HashSet;
/*      */ import java.util.Iterator;
/*      */ import java.util.LinkedHashMap;
/*      */ import java.util.LinkedList;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import java.util.Set;
/*      */ import java.util.WeakHashMap;
/*      */ import java.util.logging.Level;
/*      */ import java.util.logging.Logger;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public abstract class Structure
/*      */ {
/*  114 */   private static final Logger LOG = Logger.getLogger(Structure.class.getName());
/*      */ 
/*      */   
/*      */   public static final int ALIGN_DEFAULT = 0;
/*      */ 
/*      */   
/*      */   public static final int ALIGN_NONE = 1;
/*      */   
/*      */   public static final int ALIGN_GNUC = 2;
/*      */   
/*      */   public static final int ALIGN_MSVC = 3;
/*      */   
/*      */   protected static final int CALCULATE_SIZE = -1;
/*      */ 
/*      */   
/*      */   private static class NativeStringTracking
/*      */   {
/*      */     private final Object value;
/*      */     
/*      */     private NativeString peer;
/*      */ 
/*      */     
/*      */     NativeStringTracking(Object param1Object) {
/*  137 */       this.value = param1Object;
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
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  158 */   static final Map<Class<?>, LayoutInfo> layoutInfo = new WeakHashMap<Class<?>, LayoutInfo>();
/*  159 */   static final Map<Class<?>, List<String>> fieldOrder = new WeakHashMap<Class<?>, List<String>>();
/*      */   
/*      */   private Pointer memory;
/*      */   
/*  163 */   private int size = -1;
/*      */   
/*      */   private int alignType;
/*      */   
/*      */   private String encoding;
/*      */   private int actualAlignType;
/*      */   private int structAlignment;
/*      */   private Map<String, StructField> structFields;
/*  171 */   private final Map<String, NativeStringTracking> nativeStrings = new HashMap<String, NativeStringTracking>(8);
/*      */   
/*      */   private TypeMapper typeMapper;
/*      */   
/*      */   private long typeInfo;
/*      */   
/*      */   private boolean autoRead = true;
/*      */   private boolean autoWrite = true;
/*      */   private Structure[] array;
/*      */   private boolean readCalled;
/*      */   
/*      */   protected Structure() {
/*  183 */     this(0);
/*      */   }
/*      */   
/*      */   protected Structure(TypeMapper paramTypeMapper) {
/*  187 */     this(null, 0, paramTypeMapper);
/*      */   }
/*      */   
/*      */   protected Structure(int paramInt) {
/*  191 */     this((Pointer)null, paramInt);
/*      */   }
/*      */   
/*      */   protected Structure(int paramInt, TypeMapper paramTypeMapper) {
/*  195 */     this(null, paramInt, paramTypeMapper);
/*      */   }
/*      */ 
/*      */   
/*      */   protected Structure(Pointer paramPointer) {
/*  200 */     this(paramPointer, 0);
/*      */   }
/*      */   
/*      */   protected Structure(Pointer paramPointer, int paramInt) {
/*  204 */     this(paramPointer, paramInt, null);
/*      */   }
/*      */   
/*      */   protected Structure(Pointer paramPointer, int paramInt, TypeMapper paramTypeMapper) {
/*  208 */     setAlignType(paramInt);
/*  209 */     setStringEncoding(Native.getStringEncoding(getClass()));
/*  210 */     initializeTypeMapper(paramTypeMapper);
/*  211 */     validateFields();
/*  212 */     if (paramPointer != null) {
/*  213 */       useMemory(paramPointer, 0, true);
/*      */     } else {
/*      */       
/*  216 */       allocateMemory(-1);
/*      */     } 
/*  218 */     initializeFields();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   Map<String, StructField> fields() {
/*  229 */     return this.structFields;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   TypeMapper getTypeMapper() {
/*  236 */     return this.typeMapper;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void initializeTypeMapper(TypeMapper paramTypeMapper) {
/*  246 */     if (paramTypeMapper == null) {
/*  247 */       paramTypeMapper = Native.getTypeMapper(getClass());
/*      */     }
/*  249 */     this.typeMapper = paramTypeMapper;
/*  250 */     layoutChanged();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void layoutChanged() {
/*  257 */     if (this.size != -1) {
/*  258 */       this.size = -1;
/*  259 */       if (this.memory instanceof AutoAllocated) {
/*  260 */         this.memory = null;
/*      */       }
/*      */       
/*  263 */       ensureAllocated();
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void setStringEncoding(String paramString) {
/*  272 */     this.encoding = paramString;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected String getStringEncoding() {
/*  280 */     return this.encoding;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void setAlignType(int paramInt) {
/*  289 */     this.alignType = paramInt;
/*  290 */     if (paramInt == 0) {
/*  291 */       paramInt = Native.getStructureAlignment(getClass());
/*  292 */       if (paramInt == 0)
/*  293 */         if (Platform.isWindows()) {
/*  294 */           paramInt = 3;
/*      */         } else {
/*  296 */           paramInt = 2;
/*      */         }  
/*      */     } 
/*  299 */     this.actualAlignType = paramInt;
/*  300 */     layoutChanged();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected Memory autoAllocate(int paramInt) {
/*  309 */     return new AutoAllocated(paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void useMemory(Pointer paramPointer) {
/*  319 */     useMemory(paramPointer, 0);
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
/*      */   protected void useMemory(Pointer paramPointer, int paramInt) {
/*  331 */     useMemory(paramPointer, paramInt, false);
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
/*      */   void useMemory(Pointer paramPointer, int paramInt, boolean paramBoolean) {
/*      */     try {
/*  347 */       this.nativeStrings.clear();
/*      */       
/*  349 */       if (this instanceof ByValue && !paramBoolean) {
/*      */ 
/*      */         
/*  352 */         byte[] arrayOfByte = new byte[size()];
/*  353 */         paramPointer.read(0L, arrayOfByte, 0, arrayOfByte.length);
/*  354 */         this.memory.write(0L, arrayOfByte, 0, arrayOfByte.length);
/*      */       } else {
/*      */         
/*  357 */         if (this.size == -1) {
/*  358 */           this.size = calculateSize(false);
/*      */         }
/*  360 */         if (this.size != -1) {
/*  361 */           this.memory = paramPointer.share(paramInt, this.size);
/*      */         }
/*      */         else {
/*      */           
/*  365 */           this.memory = paramPointer.share(paramInt);
/*      */         } 
/*      */       } 
/*  368 */       this.array = null;
/*  369 */       this.readCalled = false;
/*      */     }
/*  371 */     catch (IndexOutOfBoundsException indexOutOfBoundsException) {
/*  372 */       throw new IllegalArgumentException("Structure exceeds provided memory bounds", indexOutOfBoundsException);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   protected void ensureAllocated() {
/*  379 */     ensureAllocated(false);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void ensureAllocated(boolean paramBoolean) {
/*  388 */     if (this.memory == null) {
/*  389 */       allocateMemory(paramBoolean);
/*      */     }
/*  391 */     else if (this.size == -1) {
/*  392 */       this.size = calculateSize(true, paramBoolean);
/*  393 */       if (!(this.memory instanceof AutoAllocated)) {
/*      */         
/*      */         try {
/*  396 */           this.memory = this.memory.share(0L, this.size);
/*      */         }
/*  398 */         catch (IndexOutOfBoundsException indexOutOfBoundsException) {
/*  399 */           throw new IllegalArgumentException("Structure exceeds provided memory bounds", indexOutOfBoundsException);
/*      */         } 
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void allocateMemory() {
/*  409 */     allocateMemory(false);
/*      */   }
/*      */   
/*      */   private void allocateMemory(boolean paramBoolean) {
/*  413 */     allocateMemory(calculateSize(true, paramBoolean));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void allocateMemory(int paramInt) {
/*  424 */     if (paramInt == -1) {
/*      */       
/*  426 */       paramInt = calculateSize(false);
/*      */     }
/*  428 */     else if (paramInt <= 0) {
/*  429 */       throw new IllegalArgumentException("Structure size must be greater than zero: " + paramInt);
/*      */     } 
/*      */ 
/*      */     
/*  433 */     if (paramInt != -1) {
/*  434 */       if (this.memory == null || this.memory instanceof AutoAllocated)
/*      */       {
/*  436 */         this.memory = autoAllocate(paramInt);
/*      */       }
/*  438 */       this.size = paramInt;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int size() {
/*  446 */     ensureAllocated();
/*  447 */     return this.size;
/*      */   }
/*      */ 
/*      */   
/*      */   public void clear() {
/*  452 */     ensureAllocated();
/*      */     
/*  454 */     this.nativeStrings.clear();
/*  455 */     this.memory.clear(size());
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
/*      */   public Pointer getPointer() {
/*  469 */     ensureAllocated();
/*  470 */     return this.memory;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  479 */   private static final ThreadLocal<Map<Pointer, Structure>> reads = new ThreadLocal<Map<Pointer, Structure>>()
/*      */     {
/*      */       protected synchronized Map<Pointer, Structure> initialValue() {
/*  482 */         return new HashMap<Pointer, Structure>();
/*      */       }
/*      */     };
/*      */ 
/*      */ 
/*      */   
/*  488 */   private static final ThreadLocal<Set<Structure>> busy = new ThreadLocal<Set<Structure>>()
/*      */     {
/*      */       protected synchronized Set<Structure> initialValue() {
/*  491 */         return new Structure.StructureSet();
/*      */       }
/*      */     };
/*      */   
/*      */   static class StructureSet
/*      */     extends AbstractCollection<Structure>
/*      */     implements Set<Structure> {
/*      */     Structure[] elements;
/*      */     private int count;
/*      */     
/*      */     private void ensureCapacity(int param1Int) {
/*  502 */       if (this.elements == null) {
/*  503 */         this.elements = new Structure[param1Int * 3 / 2];
/*      */       }
/*  505 */       else if (this.elements.length < param1Int) {
/*  506 */         Structure[] arrayOfStructure = new Structure[param1Int * 3 / 2];
/*  507 */         System.arraycopy(this.elements, 0, arrayOfStructure, 0, this.elements.length);
/*  508 */         this.elements = arrayOfStructure;
/*      */       } 
/*      */     }
/*      */     public Structure[] getElements() {
/*  512 */       return this.elements;
/*      */     }
/*      */     public int size() {
/*  515 */       return this.count;
/*      */     }
/*      */     public boolean contains(Object param1Object) {
/*  518 */       return (indexOf((Structure)param1Object) != -1);
/*      */     }
/*      */     
/*      */     public boolean add(Structure param1Structure) {
/*  522 */       if (!contains(param1Structure)) {
/*  523 */         ensureCapacity(this.count + 1);
/*  524 */         this.elements[this.count++] = param1Structure;
/*  525 */         return true;
/*      */       } 
/*  527 */       return false;
/*      */     }
/*      */     private int indexOf(Structure param1Structure) {
/*  530 */       for (byte b = 0; b < this.count; b++) {
/*  531 */         Structure structure = this.elements[b];
/*  532 */         if (param1Structure == structure || (param1Structure
/*  533 */           .getClass() == structure.getClass() && param1Structure
/*  534 */           .size() == structure.size() && param1Structure
/*  535 */           .getPointer().equals(structure.getPointer()))) {
/*  536 */           return b;
/*      */         }
/*      */       } 
/*  539 */       return -1;
/*      */     }
/*      */     
/*      */     public boolean remove(Object param1Object) {
/*  543 */       int i = indexOf((Structure)param1Object);
/*  544 */       if (i != -1) {
/*  545 */         if (--this.count >= 0) {
/*  546 */           this.elements[i] = this.elements[this.count];
/*  547 */           this.elements[this.count] = null;
/*      */         } 
/*  549 */         return true;
/*      */       } 
/*  551 */       return false;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public Iterator<Structure> iterator() {
/*  558 */       Structure[] arrayOfStructure = new Structure[this.count];
/*  559 */       if (this.count > 0) {
/*  560 */         System.arraycopy(this.elements, 0, arrayOfStructure, 0, this.count);
/*      */       }
/*  562 */       return Arrays.<Structure>asList(arrayOfStructure).iterator();
/*      */     }
/*      */   }
/*      */   
/*      */   static Set<Structure> busy() {
/*  567 */     return busy.get();
/*      */   }
/*      */   static Map<Pointer, Structure> reading() {
/*  570 */     return reads.get();
/*      */   }
/*      */ 
/*      */   
/*      */   void conditionalAutoRead() {
/*  575 */     if (!this.readCalled) {
/*  576 */       autoRead();
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void read() {
/*  585 */     if (this.memory == PLACEHOLDER_MEMORY) {
/*      */       return;
/*      */     }
/*  588 */     this.readCalled = true;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  594 */     ensureAllocated();
/*      */ 
/*      */     
/*  597 */     if (!busy().add(this)) {
/*      */       return;
/*      */     }
/*  600 */     if (this instanceof ByReference) {
/*  601 */       reading().put(getPointer(), this);
/*      */     }
/*      */     try {
/*  604 */       for (StructField structField : fields().values()) {
/*  605 */         readField(structField);
/*      */       }
/*      */     } finally {
/*      */       
/*  609 */       busy().remove(this);
/*  610 */       if (this instanceof ByReference && reading().get(getPointer()) == this) {
/*  611 */         reading().remove(getPointer());
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected int fieldOffset(String paramString) {
/*  621 */     ensureAllocated();
/*  622 */     StructField structField = fields().get(paramString);
/*  623 */     if (structField == null) {
/*  624 */       throw new IllegalArgumentException("No such field: " + paramString);
/*      */     }
/*  626 */     return structField.offset;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Object readField(String paramString) {
/*  636 */     ensureAllocated();
/*  637 */     StructField structField = fields().get(paramString);
/*  638 */     if (structField == null)
/*  639 */       throw new IllegalArgumentException("No such field: " + paramString); 
/*  640 */     return readField(structField);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   Object getFieldValue(Field paramField) {
/*      */     try {
/*  650 */       return paramField.get(this);
/*      */     }
/*  652 */     catch (Exception exception) {
/*  653 */       throw new Error("Exception reading field '" + paramField.getName() + "' in " + getClass(), exception);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   void setFieldValue(Field paramField, Object paramObject) {
/*  662 */     setFieldValue(paramField, paramObject, false);
/*      */   }
/*      */ 
/*      */   
/*      */   private void setFieldValue(Field paramField, Object paramObject, boolean paramBoolean) {
/*      */     try {
/*  668 */       paramField.set(this, paramObject);
/*      */     }
/*  670 */     catch (IllegalAccessException illegalAccessException) {
/*  671 */       int i = paramField.getModifiers();
/*  672 */       if (Modifier.isFinal(i)) {
/*  673 */         if (paramBoolean)
/*      */         {
/*      */           
/*  676 */           throw new UnsupportedOperationException("This VM does not support Structures with final fields (field '" + paramField.getName() + "' within " + getClass() + ")", illegalAccessException);
/*      */         }
/*  678 */         throw new UnsupportedOperationException("Attempt to write to read-only field '" + paramField.getName() + "' within " + getClass(), illegalAccessException);
/*      */       } 
/*  680 */       throw new Error("Unexpectedly unable to write to field '" + paramField.getName() + "' within " + getClass(), illegalAccessException);
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
/*      */   static <T extends Structure> T updateStructureByReference(Class<T> paramClass, T paramT, Pointer paramPointer) {
/*  692 */     if (paramPointer == null) {
/*  693 */       paramT = null;
/*      */     
/*      */     }
/*  696 */     else if (paramT == null || !paramPointer.equals(paramT.getPointer())) {
/*  697 */       Structure structure = reading().get(paramPointer);
/*  698 */       if (structure != null && paramClass.equals(structure.getClass())) {
/*  699 */         Structure structure1 = structure;
/*  700 */         structure1.autoRead();
/*      */       } else {
/*      */         
/*  703 */         paramT = newInstance(paramClass, paramPointer);
/*  704 */         paramT.conditionalAutoRead();
/*      */       } 
/*      */     } else {
/*      */       
/*  708 */       paramT.autoRead();
/*      */     } 
/*      */     
/*  711 */     return paramT;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected Object readField(StructField paramStructField) {
/*      */     Object object2;
/*  723 */     int i = paramStructField.offset;
/*      */ 
/*      */     
/*  726 */     Class<?> clazz = paramStructField.type;
/*  727 */     FromNativeConverter fromNativeConverter = paramStructField.readConverter;
/*  728 */     if (fromNativeConverter != null) {
/*  729 */       clazz = fromNativeConverter.nativeType();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  738 */     Object object1 = (Structure.class.isAssignableFrom(clazz) || Callback.class.isAssignableFrom(clazz) || (Platform.HAS_BUFFERS && Buffer.class.isAssignableFrom(clazz)) || Pointer.class.isAssignableFrom(clazz) || NativeMapped.class.isAssignableFrom(clazz) || clazz.isArray()) ? getFieldValue(paramStructField.field) : null;
/*      */ 
/*      */     
/*  741 */     if (clazz == String.class) {
/*  742 */       Pointer pointer = this.memory.getPointer(i);
/*  743 */       object2 = (pointer == null) ? null : pointer.getString(0L, this.encoding);
/*      */     } else {
/*      */       
/*  746 */       object2 = this.memory.getValue(i, clazz, object1);
/*      */     } 
/*  748 */     if (fromNativeConverter != null) {
/*  749 */       object2 = fromNativeConverter.fromNative(object2, paramStructField.context);
/*  750 */       if (object1 != null && object1.equals(object2)) {
/*  751 */         object2 = object1;
/*      */       }
/*      */     } 
/*      */     
/*  755 */     if (clazz.equals(String.class) || clazz
/*  756 */       .equals(WString.class)) {
/*  757 */       if (object2 != null) {
/*  758 */         NativeStringTracking nativeStringTracking1 = new NativeStringTracking(object2);
/*  759 */         NativeStringTracking nativeStringTracking2 = this.nativeStrings.put(paramStructField.name, nativeStringTracking1);
/*      */         
/*  761 */         if (nativeStringTracking2 != null)
/*      */         {
/*  763 */           nativeStringTracking1.peer = nativeStringTracking2.peer;
/*      */         }
/*      */       } else {
/*      */         
/*  767 */         this.nativeStrings.remove(paramStructField.name);
/*      */       } 
/*      */     }
/*      */ 
/*      */     
/*  772 */     setFieldValue(paramStructField.field, object2, true);
/*  773 */     return object2;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void write() {
/*  781 */     if (this.memory == PLACEHOLDER_MEMORY) {
/*      */       return;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  788 */     ensureAllocated();
/*      */ 
/*      */     
/*  791 */     if (this instanceof ByValue) {
/*  792 */       getTypeInfo();
/*      */     }
/*      */ 
/*      */     
/*  796 */     if (!busy().add(this)) {
/*      */       return;
/*      */     }
/*      */     
/*      */     try {
/*  801 */       for (StructField structField : fields().values()) {
/*  802 */         if (!structField.isVolatile) {
/*  803 */           writeField(structField);
/*      */         }
/*      */       } 
/*      */     } finally {
/*      */       
/*  808 */       busy().remove(this);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void writeField(String paramString) {
/*  818 */     ensureAllocated();
/*  819 */     StructField structField = fields().get(paramString);
/*  820 */     if (structField == null)
/*  821 */       throw new IllegalArgumentException("No such field: " + paramString); 
/*  822 */     writeField(structField);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void writeField(String paramString, Object paramObject) {
/*  833 */     ensureAllocated();
/*  834 */     StructField structField = fields().get(paramString);
/*  835 */     if (structField == null)
/*  836 */       throw new IllegalArgumentException("No such field: " + paramString); 
/*  837 */     setFieldValue(structField.field, paramObject);
/*  838 */     writeField(structField, paramObject);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void writeField(StructField paramStructField) {
/*  846 */     if (paramStructField.isReadOnly) {
/*      */       return;
/*      */     }
/*      */     
/*  850 */     Object object = getFieldValue(paramStructField.field);
/*      */     
/*  852 */     writeField(paramStructField, object);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void writeField(StructField paramStructField, Object paramObject) {
/*  862 */     int i = paramStructField.offset;
/*      */ 
/*      */     
/*  865 */     Class<?> clazz = paramStructField.type;
/*  866 */     ToNativeConverter toNativeConverter = paramStructField.writeConverter;
/*  867 */     if (toNativeConverter != null) {
/*  868 */       paramObject = toNativeConverter.toNative(paramObject, new StructureWriteContext(this, paramStructField.field));
/*  869 */       clazz = toNativeConverter.nativeType();
/*      */     } 
/*      */ 
/*      */     
/*  873 */     if (String.class == clazz || WString.class == clazz)
/*      */     {
/*  875 */       if (paramObject != null) {
/*  876 */         NativeStringTracking nativeStringTracking1 = new NativeStringTracking(paramObject);
/*  877 */         NativeStringTracking nativeStringTracking2 = this.nativeStrings.put(paramStructField.name, nativeStringTracking1);
/*      */ 
/*      */ 
/*      */         
/*  881 */         if (nativeStringTracking2 != null && paramObject.equals(nativeStringTracking2.value)) {
/*      */           
/*  883 */           nativeStringTracking1.peer = nativeStringTracking2.peer;
/*      */           
/*      */           return;
/*      */         } 
/*  887 */         boolean bool = (clazz == WString.class) ? true : false;
/*      */ 
/*      */         
/*  890 */         NativeString nativeString = bool ? new NativeString(paramObject.toString(), true) : new NativeString(paramObject.toString(), this.encoding);
/*      */         
/*  892 */         nativeStringTracking1.peer = nativeString;
/*  893 */         paramObject = nativeString.getPointer();
/*      */       } else {
/*      */         
/*  896 */         this.nativeStrings.remove(paramStructField.name);
/*      */       } 
/*      */     }
/*      */     
/*      */     try {
/*  901 */       this.memory.setValue(i, paramObject, clazz);
/*      */     }
/*  903 */     catch (IllegalArgumentException illegalArgumentException) {
/*  904 */       String str = "Structure field \"" + paramStructField.name + "\" was declared as " + paramStructField.type + ((paramStructField.type == clazz) ? "" : (" (native type " + clazz + ")")) + ", which is not supported within a Structure";
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  909 */       throw new IllegalArgumentException(str, illegalArgumentException);
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected List<String> getFieldOrder() {
/*  984 */     LinkedList<? extends String> linkedList = new LinkedList();
/*  985 */     for (Class<?> clazz = getClass(); clazz != Structure.class; clazz = clazz.getSuperclass()) {
/*  986 */       FieldOrder fieldOrder = clazz.<FieldOrder>getAnnotation(FieldOrder.class);
/*  987 */       if (fieldOrder != null) {
/*  988 */         linkedList.addAll(0, Arrays.asList(fieldOrder.value()));
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/*  993 */     return Collections.unmodifiableList(linkedList);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void sortFields(List<Field> paramList, List<String> paramList1) {
/* 1001 */     for (byte b = 0; b < paramList1.size(); b++) {
/* 1002 */       String str = paramList1.get(b);
/* 1003 */       for (byte b1 = 0; b1 < paramList.size(); b1++) {
/* 1004 */         Field field = paramList.get(b1);
/* 1005 */         if (str.equals(field.getName())) {
/* 1006 */           Collections.swap(paramList, b, b1);
/*      */           break;
/*      */         } 
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected List<Field> getFieldList() {
/* 1018 */     ArrayList<Field> arrayList = new ArrayList();
/* 1019 */     Class<?> clazz = getClass();
/* 1020 */     for (; !clazz.equals(Structure.class); 
/* 1021 */       clazz = clazz.getSuperclass()) {
/* 1022 */       ArrayList<Field> arrayList1 = new ArrayList();
/* 1023 */       Field[] arrayOfField = clazz.getDeclaredFields();
/* 1024 */       for (byte b = 0; b < arrayOfField.length; b++) {
/* 1025 */         int i = arrayOfField[b].getModifiers();
/* 1026 */         if (!Modifier.isStatic(i) && Modifier.isPublic(i))
/*      */         {
/*      */           
/* 1029 */           arrayList1.add(arrayOfField[b]); } 
/*      */       } 
/* 1031 */       arrayList.addAll(0, arrayList1);
/*      */     } 
/* 1033 */     return arrayList;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private List<String> fieldOrder() {
/* 1040 */     Class<?> clazz = getClass();
/* 1041 */     synchronized (fieldOrder) {
/* 1042 */       List<String> list = fieldOrder.get(clazz);
/* 1043 */       if (list == null) {
/* 1044 */         list = getFieldOrder();
/* 1045 */         fieldOrder.put(clazz, list);
/*      */       } 
/* 1047 */       return list;
/*      */     } 
/*      */   }
/*      */   
/*      */   public static List<String> createFieldsOrder(List<String> paramList, String... paramVarArgs) {
/* 1052 */     return createFieldsOrder(paramList, Arrays.asList(paramVarArgs));
/*      */   }
/*      */   
/*      */   public static List<String> createFieldsOrder(List<String> paramList1, List<String> paramList2) {
/* 1056 */     ArrayList<String> arrayList = new ArrayList(paramList1.size() + paramList2.size());
/* 1057 */     arrayList.addAll(paramList1);
/* 1058 */     arrayList.addAll(paramList2);
/* 1059 */     return Collections.unmodifiableList(arrayList);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static List<String> createFieldsOrder(String paramString) {
/* 1067 */     return Collections.unmodifiableList(Collections.singletonList(paramString));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static List<String> createFieldsOrder(String... paramVarArgs) {
/* 1075 */     return Collections.unmodifiableList(Arrays.asList(paramVarArgs));
/*      */   }
/*      */   
/*      */   private static <T extends Comparable<T>> List<T> sort(Collection<? extends T> paramCollection) {
/* 1079 */     ArrayList<T> arrayList = new ArrayList<T>(paramCollection);
/* 1080 */     Collections.sort(arrayList);
/* 1081 */     return arrayList;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected List<Field> getFields(boolean paramBoolean) {
/* 1092 */     List<Field> list = getFieldList();
/* 1093 */     HashSet<String> hashSet1 = new HashSet();
/* 1094 */     for (Field field : list) {
/* 1095 */       hashSet1.add(field.getName());
/*      */     }
/*      */     
/* 1098 */     List<String> list1 = fieldOrder();
/* 1099 */     if (list1.size() != list.size() && list.size() > 1) {
/* 1100 */       if (paramBoolean) {
/* 1101 */         throw new Error("Structure.getFieldOrder() on " + getClass() + (
/* 1102 */             (list1.size() < list.size()) ? " does not provide enough" : " provides too many") + " names [" + list1
/*      */ 
/*      */             
/* 1105 */             .size() + "] (" + 
/*      */             
/* 1107 */             sort(list1) + ") to match declared fields [" + list
/* 1108 */             .size() + "] (" + 
/*      */             
/* 1110 */             sort(hashSet1) + ")");
/*      */       }
/*      */       
/* 1113 */       return null;
/*      */     } 
/*      */     
/* 1116 */     HashSet<String> hashSet2 = new HashSet<String>(list1);
/* 1117 */     if (!hashSet2.equals(hashSet1)) {
/* 1118 */       throw new Error("Structure.getFieldOrder() on " + getClass() + " returns names (" + 
/*      */           
/* 1120 */           sort(list1) + ") which do not match declared field names (" + 
/*      */           
/* 1122 */           sort(hashSet1) + ")");
/*      */     }
/*      */     
/* 1125 */     sortFields(list, list1);
/* 1126 */     return list;
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
/*      */   protected int calculateSize(boolean paramBoolean) {
/* 1144 */     return calculateSize(paramBoolean, false);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   static int size(Class<? extends Structure> paramClass) {
/* 1152 */     return size(paramClass, null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   static <T extends Structure> int size(Class<T> paramClass, T paramT) {
/*      */     LayoutInfo layoutInfo;
/* 1162 */     synchronized (layoutInfo) {
/* 1163 */       layoutInfo = layoutInfo.get(paramClass);
/*      */     } 
/* 1165 */     int i = (layoutInfo != null && !layoutInfo.variable) ? layoutInfo.size : -1;
/* 1166 */     if (i == -1) {
/* 1167 */       if (paramT == null) {
/* 1168 */         paramT = newInstance(paramClass, PLACEHOLDER_MEMORY);
/*      */       }
/* 1170 */       i = paramT.size();
/*      */     } 
/* 1172 */     return i;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   int calculateSize(boolean paramBoolean1, boolean paramBoolean2) {
/*      */     LayoutInfo layoutInfo;
/* 1183 */     int i = -1;
/* 1184 */     Class<?> clazz = getClass();
/*      */     
/* 1186 */     synchronized (layoutInfo) {
/* 1187 */       layoutInfo = layoutInfo.get(clazz);
/*      */     } 
/* 1189 */     if (layoutInfo == null || this.alignType != layoutInfo
/* 1190 */       .alignType || this.typeMapper != layoutInfo
/* 1191 */       .typeMapper) {
/* 1192 */       layoutInfo = deriveLayout(paramBoolean1, paramBoolean2);
/*      */     }
/* 1194 */     if (layoutInfo != null) {
/* 1195 */       this.structAlignment = layoutInfo.alignment;
/* 1196 */       this.structFields = layoutInfo.fields;
/*      */       
/* 1198 */       if (!layoutInfo.variable) {
/* 1199 */         synchronized (layoutInfo) {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 1205 */           if (!layoutInfo.containsKey(clazz) || this.alignType != 0 || this.typeMapper != null)
/*      */           {
/*      */             
/* 1208 */             layoutInfo.put(clazz, layoutInfo);
/*      */           }
/*      */         } 
/*      */       }
/* 1212 */       i = layoutInfo.size;
/*      */     } 
/* 1214 */     return i;
/*      */   }
/*      */   
/*      */   private static class LayoutInfo
/*      */   {
/*      */     private LayoutInfo() {}
/*      */     
/* 1221 */     private int size = -1;
/* 1222 */     private int alignment = 1;
/* 1223 */     private final Map<String, Structure.StructField> fields = Collections.synchronizedMap(new LinkedHashMap<String, Structure.StructField>());
/* 1224 */     private int alignType = 0;
/*      */     private TypeMapper typeMapper;
/*      */     private boolean variable;
/*      */   }
/*      */   
/*      */   private void validateField(String paramString, Class<?> paramClass) {
/* 1230 */     if (this.typeMapper != null) {
/* 1231 */       ToNativeConverter toNativeConverter = this.typeMapper.getToNativeConverter(paramClass);
/* 1232 */       if (toNativeConverter != null) {
/* 1233 */         validateField(paramString, toNativeConverter.nativeType());
/*      */         return;
/*      */       } 
/*      */     } 
/* 1237 */     if (paramClass.isArray()) {
/* 1238 */       validateField(paramString, paramClass.getComponentType());
/*      */     } else {
/*      */       
/*      */       try {
/* 1242 */         getNativeSize(paramClass);
/*      */       }
/* 1244 */       catch (IllegalArgumentException illegalArgumentException) {
/* 1245 */         String str = "Invalid Structure field in " + getClass() + ", field name '" + paramString + "' (" + paramClass + "): " + illegalArgumentException.getMessage();
/* 1246 */         throw new IllegalArgumentException(str, illegalArgumentException);
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private void validateFields() {
/* 1253 */     List<Field> list = getFieldList();
/* 1254 */     for (Field field : list) {
/* 1255 */       validateField(field.getName(), field.getType());
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private LayoutInfo deriveLayout(boolean paramBoolean1, boolean paramBoolean2) {
/* 1264 */     int i = 0;
/* 1265 */     List<Field> list = getFields(paramBoolean1);
/* 1266 */     if (list == null) {
/* 1267 */       return null;
/*      */     }
/*      */     
/* 1270 */     LayoutInfo layoutInfo = new LayoutInfo();
/* 1271 */     layoutInfo.alignType = this.alignType;
/* 1272 */     layoutInfo.typeMapper = this.typeMapper;
/*      */     
/* 1274 */     boolean bool = true;
/* 1275 */     for (Field field : list) {
/*      */       
/* 1277 */       int j = field.getModifiers();
/*      */       
/* 1279 */       Class<?> clazz = field.getType();
/* 1280 */       if (clazz.isArray()) {
/* 1281 */         layoutInfo.variable = true;
/*      */       }
/* 1283 */       StructField structField = new StructField();
/* 1284 */       structField.isVolatile = Modifier.isVolatile(j);
/* 1285 */       structField.isReadOnly = Modifier.isFinal(j);
/* 1286 */       if (structField.isReadOnly) {
/* 1287 */         if (!Platform.RO_FIELDS) {
/* 1288 */           throw new IllegalArgumentException("This VM does not support read-only fields (field '" + field
/* 1289 */               .getName() + "' within " + getClass() + ")");
/*      */         }
/*      */ 
/*      */         
/* 1293 */         field.setAccessible(true);
/*      */       } 
/* 1295 */       structField.field = field;
/* 1296 */       structField.name = field.getName();
/* 1297 */       structField.type = clazz;
/*      */ 
/*      */       
/* 1300 */       if (Callback.class.isAssignableFrom(clazz) && !clazz.isInterface()) {
/* 1301 */         throw new IllegalArgumentException("Structure Callback field '" + field
/* 1302 */             .getName() + "' must be an interface");
/*      */       }
/*      */       
/* 1305 */       if (clazz.isArray() && Structure.class
/* 1306 */         .equals(clazz.getComponentType())) {
/* 1307 */         String str = "Nested Structure arrays must use a derived Structure type so that the size of the elements can be determined";
/*      */ 
/*      */         
/* 1310 */         throw new IllegalArgumentException(str);
/*      */       } 
/*      */       
/* 1313 */       int k = 1;
/* 1314 */       if (Modifier.isPublic(field.getModifiers())) {
/*      */ 
/*      */ 
/*      */         
/* 1318 */         Object object = getFieldValue(structField.field);
/* 1319 */         if (object == null && clazz.isArray()) {
/* 1320 */           if (paramBoolean1) {
/* 1321 */             throw new IllegalStateException("Array fields must be initialized");
/*      */           }
/*      */           
/* 1324 */           return null;
/*      */         } 
/* 1326 */         Class<?> clazz1 = clazz;
/* 1327 */         if (NativeMapped.class.isAssignableFrom(clazz)) {
/* 1328 */           NativeMappedConverter nativeMappedConverter = NativeMappedConverter.getInstance(clazz);
/* 1329 */           clazz1 = nativeMappedConverter.nativeType();
/* 1330 */           structField.writeConverter = nativeMappedConverter;
/* 1331 */           structField.readConverter = nativeMappedConverter;
/* 1332 */           structField.context = new StructureReadContext(this, field);
/*      */         }
/* 1334 */         else if (this.typeMapper != null) {
/* 1335 */           ToNativeConverter toNativeConverter = this.typeMapper.getToNativeConverter(clazz);
/* 1336 */           FromNativeConverter fromNativeConverter = this.typeMapper.getFromNativeConverter(clazz);
/* 1337 */           if (toNativeConverter != null && fromNativeConverter != null) {
/* 1338 */             object = toNativeConverter.toNative(object, new StructureWriteContext(this, structField.field));
/*      */             
/* 1340 */             clazz1 = (object != null) ? object.getClass() : Pointer.class;
/* 1341 */             structField.writeConverter = toNativeConverter;
/* 1342 */             structField.readConverter = fromNativeConverter;
/* 1343 */             structField.context = new StructureReadContext(this, field);
/*      */           }
/* 1345 */           else if (toNativeConverter != null || fromNativeConverter != null) {
/* 1346 */             String str = "Structures require bidirectional type conversion for " + clazz;
/* 1347 */             throw new IllegalArgumentException(str);
/*      */           } 
/*      */         } 
/*      */         
/* 1351 */         if (object == null) {
/* 1352 */           object = initializeField(structField.field, clazz);
/*      */         }
/*      */         
/*      */         try {
/* 1356 */           structField.size = getNativeSize(clazz1, object);
/* 1357 */           k = getNativeAlignment(clazz1, object, bool);
/*      */         }
/* 1359 */         catch (IllegalArgumentException illegalArgumentException) {
/*      */           
/* 1361 */           if (!paramBoolean1 && this.typeMapper == null) {
/* 1362 */             return null;
/*      */           }
/* 1364 */           String str = "Invalid Structure field in " + getClass() + ", field name '" + structField.name + "' (" + structField.type + "): " + illegalArgumentException.getMessage();
/* 1365 */           throw new IllegalArgumentException(str, illegalArgumentException);
/*      */         } 
/*      */ 
/*      */         
/* 1369 */         if (k == 0) {
/* 1370 */           throw new Error("Field alignment is zero for field '" + structField.name + "' within " + getClass());
/*      */         }
/* 1372 */         layoutInfo.alignment = Math.max(layoutInfo.alignment, k);
/* 1373 */         if (i % k != 0) {
/* 1374 */           i += k - i % k;
/*      */         }
/* 1376 */         if (this instanceof Union) {
/* 1377 */           structField.offset = 0;
/* 1378 */           i = Math.max(i, structField.size);
/*      */         } else {
/*      */           
/* 1381 */           structField.offset = i;
/* 1382 */           i += structField.size;
/*      */         } 
/*      */ 
/*      */         
/* 1386 */         layoutInfo.fields.put(structField.name, structField);
/*      */       }  bool = false;
/*      */     } 
/* 1389 */     if (i > 0) {
/* 1390 */       int j = addPadding(i, layoutInfo.alignment);
/*      */       
/* 1392 */       if (this instanceof ByValue && !paramBoolean2) {
/* 1393 */         getTypeInfo();
/*      */       }
/* 1395 */       layoutInfo.size = j;
/* 1396 */       return layoutInfo;
/*      */     } 
/*      */     
/* 1399 */     throw new IllegalArgumentException("Structure " + getClass() + " has unknown or zero size (ensure all fields are public)");
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
/*      */   private void initializeFields() {
/* 1411 */     List<Field> list = getFieldList();
/* 1412 */     for (Field field : list) {
/*      */       try {
/* 1414 */         Object object = field.get(this);
/* 1415 */         if (object == null) {
/* 1416 */           initializeField(field, field.getType());
/*      */         }
/*      */       }
/* 1419 */       catch (Exception exception) {
/* 1420 */         throw new Error("Exception reading field '" + field.getName() + "' in " + getClass(), exception);
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   private Object initializeField(Field paramField, Class<?> paramClass) {
/* 1426 */     NativeMapped nativeMapped = null;
/* 1427 */     if (Structure.class.isAssignableFrom(paramClass) && 
/* 1428 */       !ByReference.class.isAssignableFrom(paramClass)) {
/*      */       try {
/* 1430 */         nativeMapped = newInstance((Class)paramClass, PLACEHOLDER_MEMORY);
/* 1431 */         setFieldValue(paramField, nativeMapped);
/*      */       }
/* 1433 */       catch (IllegalArgumentException illegalArgumentException) {
/* 1434 */         String str = "Can't determine size of nested structure";
/* 1435 */         throw new IllegalArgumentException(str, illegalArgumentException);
/*      */       }
/*      */     
/* 1438 */     } else if (NativeMapped.class.isAssignableFrom(paramClass)) {
/* 1439 */       NativeMappedConverter nativeMappedConverter = NativeMappedConverter.getInstance(paramClass);
/* 1440 */       nativeMapped = nativeMappedConverter.defaultValue();
/* 1441 */       setFieldValue(paramField, nativeMapped);
/*      */     } 
/* 1443 */     return nativeMapped;
/*      */   }
/*      */   
/*      */   private int addPadding(int paramInt) {
/* 1447 */     return addPadding(paramInt, this.structAlignment);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private int addPadding(int paramInt1, int paramInt2) {
/* 1453 */     if (this.actualAlignType != 1 && 
/* 1454 */       paramInt1 % paramInt2 != 0) {
/* 1455 */       paramInt1 += paramInt2 - paramInt1 % paramInt2;
/*      */     }
/*      */     
/* 1458 */     return paramInt1;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected int getStructAlignment() {
/* 1465 */     if (this.size == -1)
/*      */     {
/* 1467 */       calculateSize(true);
/*      */     }
/* 1469 */     return this.structAlignment;
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
/*      */   protected int getNativeAlignment(Class<?> paramClass, Object paramObject, boolean paramBoolean) {
/* 1483 */     int i = 1;
/* 1484 */     if (NativeMapped.class.isAssignableFrom(paramClass)) {
/* 1485 */       NativeMappedConverter nativeMappedConverter = NativeMappedConverter.getInstance(paramClass);
/* 1486 */       paramClass = nativeMappedConverter.nativeType();
/* 1487 */       paramObject = nativeMappedConverter.toNative(paramObject, new ToNativeContext());
/*      */     } 
/* 1489 */     int j = Native.getNativeSize(paramClass, paramObject);
/* 1490 */     if (paramClass.isPrimitive() || Long.class == paramClass || Integer.class == paramClass || Short.class == paramClass || Character.class == paramClass || Byte.class == paramClass || Boolean.class == paramClass || Float.class == paramClass || Double.class == paramClass) {
/*      */ 
/*      */ 
/*      */       
/* 1494 */       i = j;
/*      */     }
/* 1496 */     else if ((Pointer.class.isAssignableFrom(paramClass) && !Function.class.isAssignableFrom(paramClass)) || (Platform.HAS_BUFFERS && Buffer.class
/* 1497 */       .isAssignableFrom(paramClass)) || Callback.class
/* 1498 */       .isAssignableFrom(paramClass) || WString.class == paramClass || String.class == paramClass) {
/*      */ 
/*      */       
/* 1501 */       i = Native.POINTER_SIZE;
/*      */     }
/* 1503 */     else if (Structure.class.isAssignableFrom(paramClass)) {
/* 1504 */       if (ByReference.class.isAssignableFrom(paramClass)) {
/* 1505 */         i = Native.POINTER_SIZE;
/*      */       } else {
/*      */         
/* 1508 */         if (paramObject == null)
/* 1509 */           paramObject = newInstance(paramClass, PLACEHOLDER_MEMORY); 
/* 1510 */         i = ((Structure)paramObject).getStructAlignment();
/*      */       }
/*      */     
/* 1513 */     } else if (paramClass.isArray()) {
/* 1514 */       i = getNativeAlignment(paramClass.getComponentType(), null, paramBoolean);
/*      */     } else {
/*      */       
/* 1517 */       throw new IllegalArgumentException("Type " + paramClass + " has unknown native alignment");
/*      */     } 
/*      */     
/* 1520 */     if (this.actualAlignType == 1) {
/* 1521 */       i = 1;
/*      */     }
/* 1523 */     else if (this.actualAlignType == 3) {
/* 1524 */       i = Math.min(8, i);
/*      */     }
/* 1526 */     else if (this.actualAlignType == 2) {
/*      */ 
/*      */       
/* 1529 */       if (!paramBoolean || !Platform.isMac() || !Platform.isPPC()) {
/* 1530 */         i = Math.min(Native.MAX_ALIGNMENT, i);
/*      */       }
/* 1532 */       if (!paramBoolean && Platform.isAIX() && (paramClass == double.class || paramClass == Double.class)) {
/* 1533 */         i = 4;
/*      */       }
/*      */     } 
/* 1536 */     return i;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String toString() {
/* 1546 */     return toString(Boolean.getBoolean("jna.dump_memory"));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String toString(boolean paramBoolean) {
/* 1555 */     return toString(0, true, paramBoolean);
/*      */   }
/*      */   
/*      */   private String format(Class<?> paramClass) {
/* 1559 */     String str = paramClass.getName();
/* 1560 */     int i = str.lastIndexOf(".");
/* 1561 */     return str.substring(i + 1);
/*      */   }
/*      */   
/*      */   private String toString(int paramInt, boolean paramBoolean1, boolean paramBoolean2) {
/* 1565 */     ensureAllocated();
/* 1566 */     String str1 = System.getProperty("line.separator");
/* 1567 */     String str2 = format(getClass()) + "(" + getPointer() + ")";
/* 1568 */     if (!(getPointer() instanceof Memory)) {
/* 1569 */       str2 = str2 + " (" + size() + " bytes)";
/*      */     }
/* 1571 */     String str3 = "";
/* 1572 */     for (byte b = 0; b < paramInt; b++) {
/* 1573 */       str3 = str3 + "  ";
/*      */     }
/* 1575 */     String str4 = str1;
/* 1576 */     if (!paramBoolean1) {
/* 1577 */       str4 = "...}";
/*      */     } else {
/* 1579 */       for (Iterator<StructField> iterator = fields().values().iterator(); iterator.hasNext(); ) {
/* 1580 */         StructField structField = iterator.next();
/* 1581 */         Object object = getFieldValue(structField.field);
/* 1582 */         String str5 = format(structField.type);
/* 1583 */         String str6 = "";
/* 1584 */         str4 = str4 + str3;
/* 1585 */         if (structField.type.isArray() && object != null) {
/* 1586 */           str5 = format(structField.type.getComponentType());
/* 1587 */           str6 = "[" + Array.getLength(object) + "]";
/*      */         } 
/* 1589 */         str4 = str4 + String.format("  %s %s%s@0x%X", new Object[] { str5, structField.name, str6, Integer.valueOf(structField.offset) });
/* 1590 */         if (object instanceof Structure) {
/* 1591 */           object = ((Structure)object).toString(paramInt + 1, !(object instanceof ByReference), paramBoolean2);
/*      */         }
/* 1593 */         str4 = str4 + "=";
/* 1594 */         if (object instanceof Long) {
/* 1595 */           str4 = str4 + String.format("0x%08X", new Object[] { object });
/*      */         }
/* 1597 */         else if (object instanceof Integer) {
/* 1598 */           str4 = str4 + String.format("0x%04X", new Object[] { object });
/*      */         }
/* 1600 */         else if (object instanceof Short) {
/* 1601 */           str4 = str4 + String.format("0x%02X", new Object[] { object });
/*      */         }
/* 1603 */         else if (object instanceof Byte) {
/* 1604 */           str4 = str4 + String.format("0x%01X", new Object[] { object });
/*      */         } else {
/*      */           
/* 1607 */           str4 = str4 + String.valueOf(object).trim();
/*      */         } 
/* 1609 */         str4 = str4 + str1;
/* 1610 */         if (!iterator.hasNext())
/* 1611 */           str4 = str4 + str3 + "}"; 
/*      */       } 
/*      */     } 
/* 1614 */     if (paramInt == 0 && paramBoolean2) {
/* 1615 */       byte b1 = 4;
/* 1616 */       str4 = str4 + str1 + "memory dump" + str1;
/* 1617 */       byte[] arrayOfByte = getPointer().getByteArray(0L, size());
/* 1618 */       for (byte b2 = 0; b2 < arrayOfByte.length; b2++) {
/* 1619 */         if (b2 % 4 == 0) str4 = str4 + "["; 
/* 1620 */         if (arrayOfByte[b2] >= 0 && arrayOfByte[b2] < 16)
/* 1621 */           str4 = str4 + "0"; 
/* 1622 */         str4 = str4 + Integer.toHexString(arrayOfByte[b2] & 0xFF);
/* 1623 */         if (b2 % 4 == 3 && b2 < arrayOfByte.length - 1)
/* 1624 */           str4 = str4 + "]" + str1; 
/*      */       } 
/* 1626 */       str4 = str4 + "]";
/*      */     } 
/* 1628 */     return str2 + " {" + str4;
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
/*      */   public Structure[] toArray(Structure[] paramArrayOfStructure) {
/* 1640 */     ensureAllocated();
/* 1641 */     if (this.memory instanceof AutoAllocated) {
/*      */       
/* 1643 */       Memory memory = (Memory)this.memory;
/* 1644 */       int j = paramArrayOfStructure.length * size();
/* 1645 */       if (memory.size() < j) {
/* 1646 */         useMemory(autoAllocate(j));
/*      */       }
/*      */     } 
/*      */     
/* 1650 */     paramArrayOfStructure[0] = this;
/* 1651 */     int i = size();
/* 1652 */     for (byte b = 1; b < paramArrayOfStructure.length; b++) {
/* 1653 */       paramArrayOfStructure[b] = newInstance(getClass(), this.memory.share((b * i), i));
/* 1654 */       paramArrayOfStructure[b].conditionalAutoRead();
/*      */     } 
/*      */     
/* 1657 */     if (!(this instanceof ByValue))
/*      */     {
/* 1659 */       this.array = paramArrayOfStructure;
/*      */     }
/*      */     
/* 1662 */     return paramArrayOfStructure;
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
/*      */   public Structure[] toArray(int paramInt) {
/* 1675 */     return toArray((Structure[])Array.newInstance(getClass(), paramInt));
/*      */   }
/*      */   
/*      */   private Class<?> baseClass() {
/* 1679 */     if ((this instanceof ByReference || this instanceof ByValue) && Structure.class
/*      */       
/* 1681 */       .isAssignableFrom(getClass().getSuperclass())) {
/* 1682 */       return getClass().getSuperclass();
/*      */     }
/* 1684 */     return getClass();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean dataEquals(Structure paramStructure) {
/* 1693 */     return dataEquals(paramStructure, false);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean dataEquals(Structure paramStructure, boolean paramBoolean) {
/* 1703 */     if (paramBoolean) {
/* 1704 */       paramStructure.getPointer().clear(paramStructure.size());
/* 1705 */       paramStructure.write();
/* 1706 */       getPointer().clear(size());
/* 1707 */       write();
/*      */     } 
/* 1709 */     byte[] arrayOfByte1 = paramStructure.getPointer().getByteArray(0L, paramStructure.size());
/* 1710 */     byte[] arrayOfByte2 = getPointer().getByteArray(0L, size());
/* 1711 */     if (arrayOfByte1.length == arrayOfByte2.length) {
/* 1712 */       for (byte b = 0; b < arrayOfByte1.length; b++) {
/* 1713 */         if (arrayOfByte1[b] != arrayOfByte2[b]) {
/* 1714 */           return false;
/*      */         }
/*      */       } 
/* 1717 */       return true;
/*      */     } 
/* 1719 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean equals(Object paramObject) {
/* 1727 */     return (paramObject instanceof Structure && paramObject
/* 1728 */       .getClass() == getClass() && ((Structure)paramObject)
/* 1729 */       .getPointer().equals(getPointer()));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int hashCode() {
/* 1737 */     Pointer pointer = getPointer();
/* 1738 */     if (pointer != null) {
/* 1739 */       return getPointer().hashCode();
/*      */     }
/* 1741 */     return getClass().hashCode();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void cacheTypeInfo(Pointer paramPointer) {
/* 1748 */     this.typeInfo = paramPointer.peer;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   FFIType getFieldTypeInfo(StructField paramStructField) {
/* 1756 */     Class<?> clazz = paramStructField.type;
/* 1757 */     Object object = getFieldValue(paramStructField.field);
/* 1758 */     if (this.typeMapper != null) {
/* 1759 */       ToNativeConverter toNativeConverter = this.typeMapper.getToNativeConverter(clazz);
/* 1760 */       if (toNativeConverter != null) {
/* 1761 */         clazz = toNativeConverter.nativeType();
/* 1762 */         object = toNativeConverter.toNative(object, new ToNativeContext());
/*      */       } 
/*      */     } 
/* 1765 */     return FFIType.get(object, clazz);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   Pointer getTypeInfo() {
/* 1772 */     Pointer pointer = getTypeInfo(this).getPointer();
/* 1773 */     cacheTypeInfo(pointer);
/* 1774 */     return pointer;
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
/*      */   public void setAutoSynch(boolean paramBoolean) {
/* 1798 */     setAutoRead(paramBoolean);
/* 1799 */     setAutoWrite(paramBoolean);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setAutoRead(boolean paramBoolean) {
/* 1807 */     this.autoRead = paramBoolean;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean getAutoRead() {
/* 1815 */     return this.autoRead;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setAutoWrite(boolean paramBoolean) {
/* 1823 */     this.autoWrite = paramBoolean;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean getAutoWrite() {
/* 1831 */     return this.autoWrite;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   static FFIType getTypeInfo(Object paramObject) {
/* 1839 */     return FFIType.get(paramObject);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static <T extends Structure> T newInstance(Class<T> paramClass, long paramLong) {
/*      */     try {
/* 1848 */       Structure structure = (Structure)newInstance((Class)paramClass, (paramLong == 0L) ? PLACEHOLDER_MEMORY : new Pointer(paramLong));
/* 1849 */       if (paramLong != 0L) {
/* 1850 */         structure.conditionalAutoRead();
/*      */       }
/* 1852 */       return (T)structure;
/*      */     }
/* 1854 */     catch (Throwable throwable) {
/* 1855 */       LOG.log(Level.WARNING, "JNA: Error creating structure", throwable);
/* 1856 */       return null;
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
/*      */   public static <T extends Structure> T newInstance(Class<T> paramClass, Pointer paramPointer) throws IllegalArgumentException {
/*      */     try {
/* 1869 */       Constructor<T> constructor = getPointerConstructor(paramClass);
/* 1870 */       if (constructor != null) {
/* 1871 */         return constructor.newInstance(new Object[] { paramPointer });
/*      */       
/*      */       }
/*      */     }
/* 1875 */     catch (SecurityException securityException) {
/*      */ 
/*      */     
/* 1878 */     } catch (InstantiationException instantiationException) {
/* 1879 */       String str = "Can't instantiate " + paramClass;
/* 1880 */       throw new IllegalArgumentException(str, instantiationException);
/*      */     }
/* 1882 */     catch (IllegalAccessException illegalAccessException) {
/* 1883 */       String str = "Instantiation of " + paramClass + " (Pointer) not allowed, is it public?";
/* 1884 */       throw new IllegalArgumentException(str, illegalAccessException);
/*      */     }
/* 1886 */     catch (InvocationTargetException invocationTargetException) {
/* 1887 */       String str = "Exception thrown while instantiating an instance of " + paramClass;
/* 1888 */       throw new IllegalArgumentException(str, invocationTargetException);
/*      */     } 
/* 1890 */     Structure structure = (Structure)newInstance((Class)paramClass);
/* 1891 */     if (paramPointer != PLACEHOLDER_MEMORY) {
/* 1892 */       structure.useMemory(paramPointer);
/*      */     }
/* 1894 */     return (T)structure;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T extends Structure> T newInstance(Class<T> paramClass) throws IllegalArgumentException {
/* 1904 */     Structure structure = Klass.<Structure>newInstance(paramClass);
/* 1905 */     if (structure instanceof ByValue) {
/* 1906 */       structure.allocateMemory();
/*      */     }
/* 1908 */     return (T)structure;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static <T> Constructor<T> getPointerConstructor(Class<T> paramClass) {
/* 1918 */     for (Constructor<T> constructor : paramClass.getConstructors()) {
/* 1919 */       Class[] arrayOfClass = constructor.getParameterTypes();
/* 1920 */       if (arrayOfClass.length == 1 && arrayOfClass[0].equals(Pointer.class)) {
/* 1921 */         return constructor;
/*      */       }
/*      */     } 
/*      */     
/* 1925 */     return null;
/*      */   }
/*      */   
/*      */   protected static class StructField {
/*      */     public String name;
/*      */     public Class<?> type;
/*      */     public Field field;
/* 1932 */     public int size = -1;
/* 1933 */     public int offset = -1;
/*      */     public boolean isVolatile;
/*      */     public boolean isReadOnly;
/*      */     public FromNativeConverter readConverter;
/*      */     public ToNativeConverter writeConverter;
/*      */     public FromNativeContext context;
/*      */     
/*      */     public String toString() {
/* 1941 */       return this.name + "@" + this.offset + "[" + this.size + "] (" + this.type + ")";
/*      */     }
/*      */   }
/*      */   
/*      */   @FieldOrder({"size", "alignment", "type", "elements"})
/*      */   static class FFIType
/*      */     extends Structure
/*      */   {
/*      */     public static class size_t
/*      */       extends IntegerType {
/*      */       private static final long serialVersionUID = 1L;
/*      */       
/*      */       public size_t() {
/* 1954 */         this(0L); } public size_t(long param2Long) {
/* 1955 */         super(Native.SIZE_T_SIZE, param2Long);
/*      */       }
/*      */     }
/* 1958 */     private static final Map<Class, FFIType> typeInfoMap = (Map)new WeakHashMap<Class<?>, FFIType>();
/* 1959 */     private static final Map<Class, FFIType> unionHelper = (Map)new WeakHashMap<Class<?>, FFIType>();
/* 1960 */     private static final Map<Pointer, FFIType> ffiTypeInfo = new HashMap<Pointer, FFIType>(); private static final int FFI_TYPE_STRUCT = 13;
/*      */     public size_t size;
/*      */     public short alignment;
/*      */     public short type;
/*      */     public Pointer elements;
/*      */     
/*      */     private static class FFITypes {
/*      */       private static Pointer ffi_type_void;
/*      */       private static Pointer ffi_type_float;
/*      */       private static Pointer ffi_type_double;
/*      */       private static Pointer ffi_type_longdouble;
/*      */       private static Pointer ffi_type_uint8;
/*      */       private static Pointer ffi_type_sint8;
/*      */       private static Pointer ffi_type_uint16;
/*      */       private static Pointer ffi_type_sint16;
/*      */       private static Pointer ffi_type_uint32;
/*      */       private static Pointer ffi_type_sint32;
/*      */       private static Pointer ffi_type_uint64;
/*      */       private static Pointer ffi_type_sint64;
/*      */       private static Pointer ffi_type_pointer; }
/*      */     
/*      */     private static boolean isIntegerType(FFIType param1FFIType) {
/* 1982 */       Pointer pointer = param1FFIType.getPointer();
/* 1983 */       return (pointer.equals(FFITypes.ffi_type_uint8) || pointer
/* 1984 */         .equals(FFITypes.ffi_type_sint8) || pointer
/* 1985 */         .equals(FFITypes.ffi_type_uint16) || pointer
/* 1986 */         .equals(FFITypes.ffi_type_sint16) || pointer
/* 1987 */         .equals(FFITypes.ffi_type_uint32) || pointer
/* 1988 */         .equals(FFITypes.ffi_type_sint32) || pointer
/* 1989 */         .equals(FFITypes.ffi_type_uint64) || pointer
/* 1990 */         .equals(FFITypes.ffi_type_sint64) || pointer
/* 1991 */         .equals(FFITypes.ffi_type_pointer));
/*      */     }
/*      */     
/*      */     private static boolean isFloatType(FFIType param1FFIType) {
/* 1995 */       Pointer pointer = param1FFIType.getPointer();
/* 1996 */       return (pointer.equals(FFITypes.ffi_type_float) || pointer
/* 1997 */         .equals(FFITypes.ffi_type_double));
/*      */     }
/*      */     
/*      */     static {
/* 2001 */       if (Native.POINTER_SIZE == 0)
/* 2002 */         throw new Error("Native library not initialized"); 
/* 2003 */       if (FFITypes.ffi_type_void == null)
/* 2004 */         throw new Error("FFI types not initialized"); 
/* 2005 */       ffiTypeInfo.put(FFITypes.ffi_type_void, Structure.newInstance(FFIType.class, FFITypes.ffi_type_void));
/* 2006 */       ffiTypeInfo.put(FFITypes.ffi_type_float, Structure.newInstance(FFIType.class, FFITypes.ffi_type_float));
/* 2007 */       ffiTypeInfo.put(FFITypes.ffi_type_double, Structure.newInstance(FFIType.class, FFITypes.ffi_type_double));
/* 2008 */       ffiTypeInfo.put(FFITypes.ffi_type_longdouble, Structure.newInstance(FFIType.class, FFITypes.ffi_type_longdouble));
/* 2009 */       ffiTypeInfo.put(FFITypes.ffi_type_uint8, Structure.newInstance(FFIType.class, FFITypes.ffi_type_uint8));
/* 2010 */       ffiTypeInfo.put(FFITypes.ffi_type_sint8, Structure.newInstance(FFIType.class, FFITypes.ffi_type_sint8));
/* 2011 */       ffiTypeInfo.put(FFITypes.ffi_type_uint16, Structure.newInstance(FFIType.class, FFITypes.ffi_type_uint16));
/* 2012 */       ffiTypeInfo.put(FFITypes.ffi_type_sint16, Structure.newInstance(FFIType.class, FFITypes.ffi_type_sint16));
/* 2013 */       ffiTypeInfo.put(FFITypes.ffi_type_uint32, Structure.newInstance(FFIType.class, FFITypes.ffi_type_uint32));
/* 2014 */       ffiTypeInfo.put(FFITypes.ffi_type_sint32, Structure.newInstance(FFIType.class, FFITypes.ffi_type_sint32));
/* 2015 */       ffiTypeInfo.put(FFITypes.ffi_type_uint64, Structure.newInstance(FFIType.class, FFITypes.ffi_type_uint64));
/* 2016 */       ffiTypeInfo.put(FFITypes.ffi_type_sint64, Structure.newInstance(FFIType.class, FFITypes.ffi_type_sint64));
/* 2017 */       ffiTypeInfo.put(FFITypes.ffi_type_pointer, Structure.newInstance(FFIType.class, FFITypes.ffi_type_pointer));
/* 2018 */       for (FFIType fFIType1 : ffiTypeInfo.values()) {
/* 2019 */         fFIType1.read();
/*      */       }
/* 2021 */       typeInfoMap.put(void.class, ffiTypeInfo.get(FFITypes.ffi_type_void));
/* 2022 */       typeInfoMap.put(Void.class, ffiTypeInfo.get(FFITypes.ffi_type_void));
/* 2023 */       typeInfoMap.put(float.class, ffiTypeInfo.get(FFITypes.ffi_type_float));
/* 2024 */       typeInfoMap.put(Float.class, ffiTypeInfo.get(FFITypes.ffi_type_float));
/* 2025 */       typeInfoMap.put(double.class, ffiTypeInfo.get(FFITypes.ffi_type_double));
/* 2026 */       typeInfoMap.put(Double.class, ffiTypeInfo.get(FFITypes.ffi_type_double));
/* 2027 */       typeInfoMap.put(long.class, ffiTypeInfo.get(FFITypes.ffi_type_sint64));
/* 2028 */       typeInfoMap.put(Long.class, ffiTypeInfo.get(FFITypes.ffi_type_sint64));
/* 2029 */       typeInfoMap.put(int.class, ffiTypeInfo.get(FFITypes.ffi_type_sint32));
/* 2030 */       typeInfoMap.put(Integer.class, ffiTypeInfo.get(FFITypes.ffi_type_sint32));
/* 2031 */       typeInfoMap.put(short.class, ffiTypeInfo.get(FFITypes.ffi_type_sint16));
/* 2032 */       typeInfoMap.put(Short.class, ffiTypeInfo.get(FFITypes.ffi_type_sint16));
/*      */       
/* 2034 */       FFIType fFIType = (Native.WCHAR_SIZE == 2) ? ffiTypeInfo.get(FFITypes.ffi_type_uint16) : ffiTypeInfo.get(FFITypes.ffi_type_uint32);
/* 2035 */       typeInfoMap.put(char.class, fFIType);
/* 2036 */       typeInfoMap.put(Character.class, fFIType);
/* 2037 */       typeInfoMap.put(byte.class, ffiTypeInfo.get(FFITypes.ffi_type_sint8));
/* 2038 */       typeInfoMap.put(Byte.class, ffiTypeInfo.get(FFITypes.ffi_type_sint8));
/* 2039 */       typeInfoMap.put(Pointer.class, ffiTypeInfo.get(FFITypes.ffi_type_pointer));
/* 2040 */       typeInfoMap.put(String.class, ffiTypeInfo.get(FFITypes.ffi_type_pointer));
/* 2041 */       typeInfoMap.put(WString.class, ffiTypeInfo.get(FFITypes.ffi_type_pointer));
/* 2042 */       typeInfoMap.put(boolean.class, ffiTypeInfo.get(FFITypes.ffi_type_uint32));
/* 2043 */       typeInfoMap.put(Boolean.class, ffiTypeInfo.get(FFITypes.ffi_type_uint32));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public FFIType(FFIType param1FFIType) {
/* 2050 */       this.type = 13;
/*      */ 
/*      */ 
/*      */       
/* 2054 */       this.size = param1FFIType.size;
/* 2055 */       this.alignment = param1FFIType.alignment;
/* 2056 */       this.type = param1FFIType.type;
/* 2057 */       this.elements = param1FFIType.elements;
/*      */     } public FFIType() {
/*      */       this.type = 13;
/*      */     }
/*      */     public FFIType(Structure param1Structure) {
/*      */       Pointer[] arrayOfPointer;
/*      */       this.type = 13;
/* 2064 */       param1Structure.ensureAllocated(true);
/*      */       
/* 2066 */       if (param1Structure instanceof Union) {
/* 2067 */         FFIType fFIType = null;
/* 2068 */         int i = 0;
/* 2069 */         boolean bool = false;
/* 2070 */         for (Structure.StructField structField : param1Structure.fields().values()) {
/* 2071 */           FFIType fFIType1 = param1Structure.getFieldTypeInfo(structField);
/* 2072 */           if (isIntegerType(fFIType1)) {
/* 2073 */             bool = true;
/*      */           }
/* 2075 */           if (fFIType == null || i < structField.size || (i == structField.size && Structure.class
/*      */ 
/*      */             
/* 2078 */             .isAssignableFrom(structField.type))) {
/* 2079 */             fFIType = fFIType1;
/* 2080 */             i = structField.size;
/*      */           } 
/*      */         } 
/* 2083 */         if ((Platform.isIntel() && Platform.is64Bit() && !Platform.isWindows()) || 
/* 2084 */           Platform.isARM())
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 2095 */           if (bool && isFloatType(fFIType)) {
/* 2096 */             fFIType = new FFIType(fFIType);
/* 2097 */             if (fFIType.size.intValue() == 4) {
/* 2098 */               fFIType.type = ((FFIType)ffiTypeInfo.get(FFITypes.ffi_type_uint32)).type;
/* 2099 */             } else if (fFIType.size.intValue() == 8) {
/* 2100 */               fFIType.type = ((FFIType)ffiTypeInfo.get(FFITypes.ffi_type_uint64)).type;
/*      */             } 
/* 2102 */             fFIType.write();
/*      */           } 
/*      */         }
/*      */         
/* 2106 */         arrayOfPointer = new Pointer[] { fFIType.getPointer(), null };
/*      */ 
/*      */         
/* 2109 */         unionHelper.put(param1Structure.getClass(), fFIType);
/*      */       } else {
/*      */         
/* 2112 */         arrayOfPointer = new Pointer[param1Structure.fields().size() + 1];
/* 2113 */         byte b = 0;
/* 2114 */         for (Structure.StructField structField : param1Structure.fields().values()) {
/* 2115 */           arrayOfPointer[b++] = param1Structure.getFieldTypeInfo(structField).getPointer();
/*      */         }
/*      */       } 
/* 2118 */       init(arrayOfPointer);
/* 2119 */       write();
/*      */     }
/*      */     public FFIType(Object param1Object, Class<?> param1Class) {
/*      */       this.type = 13;
/* 2123 */       int i = Array.getLength(param1Object);
/* 2124 */       Pointer[] arrayOfPointer = new Pointer[i + 1];
/* 2125 */       Pointer pointer = get((Object)null, param1Class.getComponentType()).getPointer();
/* 2126 */       for (byte b = 0; b < i; b++) {
/* 2127 */         arrayOfPointer[b] = pointer;
/*      */       }
/* 2129 */       init(arrayOfPointer);
/* 2130 */       write();
/*      */     }
/*      */     
/*      */     private void init(Pointer[] param1ArrayOfPointer) {
/* 2134 */       this.elements = new Memory((Native.POINTER_SIZE * param1ArrayOfPointer.length));
/* 2135 */       this.elements.write(0L, param1ArrayOfPointer, 0, param1ArrayOfPointer.length);
/* 2136 */       write();
/*      */     }
/*      */ 
/*      */     
/*      */     static FFIType get(Object param1Object) {
/* 2141 */       if (param1Object == null)
/* 2142 */         return typeInfoMap.get(Pointer.class); 
/* 2143 */       if (param1Object instanceof Class)
/* 2144 */         return get((Object)null, (Class)param1Object); 
/* 2145 */       return get(param1Object, param1Object.getClass());
/*      */     }
/*      */     
/*      */     private static FFIType get(Object param1Object, Class<?> param1Class) {
/* 2149 */       TypeMapper typeMapper = Native.getTypeMapper(param1Class);
/* 2150 */       if (typeMapper != null) {
/* 2151 */         ToNativeConverter toNativeConverter = typeMapper.getToNativeConverter(param1Class);
/* 2152 */         if (toNativeConverter != null) {
/* 2153 */           param1Class = toNativeConverter.nativeType();
/*      */         }
/*      */       } 
/* 2156 */       synchronized (typeInfoMap) {
/* 2157 */         FFIType fFIType = typeInfoMap.get(param1Class);
/* 2158 */         if (fFIType != null) {
/* 2159 */           return fFIType;
/*      */         }
/* 2161 */         if ((Platform.HAS_BUFFERS && Buffer.class.isAssignableFrom(param1Class)) || Callback.class
/* 2162 */           .isAssignableFrom(param1Class)) {
/* 2163 */           typeInfoMap.put(param1Class, typeInfoMap.get(Pointer.class));
/* 2164 */           return typeInfoMap.get(Pointer.class);
/*      */         } 
/* 2166 */         if (Structure.class.isAssignableFrom(param1Class)) {
/* 2167 */           if (param1Object == null) param1Object = newInstance(param1Class, Structure.PLACEHOLDER_MEMORY); 
/* 2168 */           if (Structure.ByReference.class.isAssignableFrom(param1Class)) {
/* 2169 */             typeInfoMap.put(param1Class, typeInfoMap.get(Pointer.class));
/* 2170 */             return typeInfoMap.get(Pointer.class);
/*      */           } 
/* 2172 */           FFIType fFIType1 = new FFIType((Structure)param1Object);
/* 2173 */           typeInfoMap.put(param1Class, fFIType1);
/* 2174 */           return fFIType1;
/*      */         } 
/* 2176 */         if (NativeMapped.class.isAssignableFrom(param1Class)) {
/* 2177 */           NativeMappedConverter nativeMappedConverter = NativeMappedConverter.getInstance(param1Class);
/* 2178 */           return get(nativeMappedConverter.toNative(param1Object, new ToNativeContext()), nativeMappedConverter.nativeType());
/*      */         } 
/* 2180 */         if (param1Class.isArray()) {
/* 2181 */           FFIType fFIType1 = new FFIType(param1Object, param1Class);
/*      */           
/* 2183 */           typeInfoMap.put(param1Class, fFIType1);
/* 2184 */           return fFIType1;
/*      */         } 
/* 2186 */         throw new IllegalArgumentException("Unsupported type " + param1Class);
/*      */       } 
/*      */     }
/*      */   }
/*      */   
/*      */   private static class AutoAllocated extends Memory {
/*      */     public AutoAllocated(int param1Int) {
/* 2193 */       super(param1Int);
/*      */       
/* 2195 */       clear();
/*      */     }
/*      */     
/*      */     public String toString() {
/* 2199 */       return "auto-" + super.toString();
/*      */     }
/*      */   }
/*      */   
/*      */   private static void structureArrayCheck(Structure[] paramArrayOfStructure) {
/* 2204 */     if (ByReference[].class.isAssignableFrom(paramArrayOfStructure.getClass())) {
/*      */       return;
/*      */     }
/* 2207 */     Pointer pointer = paramArrayOfStructure[0].getPointer();
/* 2208 */     int i = paramArrayOfStructure[0].size();
/* 2209 */     for (byte b = 1; b < paramArrayOfStructure.length; b++) {
/* 2210 */       if ((paramArrayOfStructure[b].getPointer()).peer != pointer.peer + (i * b)) {
/* 2211 */         String str = "Structure array elements must use contiguous memory (bad backing address at Structure array index " + b + ")";
/*      */         
/* 2213 */         throw new IllegalArgumentException(str);
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   public static void autoRead(Structure[] paramArrayOfStructure) {
/* 2219 */     structureArrayCheck(paramArrayOfStructure);
/* 2220 */     if ((paramArrayOfStructure[0]).array == paramArrayOfStructure) {
/* 2221 */       paramArrayOfStructure[0].autoRead();
/*      */     } else {
/*      */       
/* 2224 */       for (byte b = 0; b < paramArrayOfStructure.length; b++) {
/* 2225 */         if (paramArrayOfStructure[b] != null) {
/* 2226 */           paramArrayOfStructure[b].autoRead();
/*      */         }
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   public void autoRead() {
/* 2233 */     if (getAutoRead()) {
/* 2234 */       read();
/* 2235 */       if (this.array != null) {
/* 2236 */         for (byte b = 1; b < this.array.length; b++) {
/* 2237 */           this.array[b].autoRead();
/*      */         }
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   public static void autoWrite(Structure[] paramArrayOfStructure) {
/* 2244 */     structureArrayCheck(paramArrayOfStructure);
/* 2245 */     if ((paramArrayOfStructure[0]).array == paramArrayOfStructure) {
/* 2246 */       paramArrayOfStructure[0].autoWrite();
/*      */     } else {
/*      */       
/* 2249 */       for (byte b = 0; b < paramArrayOfStructure.length; b++) {
/* 2250 */         if (paramArrayOfStructure[b] != null) {
/* 2251 */           paramArrayOfStructure[b].autoWrite();
/*      */         }
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   public void autoWrite() {
/* 2258 */     if (getAutoWrite()) {
/* 2259 */       write();
/* 2260 */       if (this.array != null) {
/* 2261 */         for (byte b = 1; b < this.array.length; b++) {
/* 2262 */           this.array[b].autoWrite();
/*      */         }
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected int getNativeSize(Class<?> paramClass) {
/* 2274 */     return getNativeSize(paramClass, null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected int getNativeSize(Class<?> paramClass, Object paramObject) {
/* 2284 */     return Native.getNativeSize(paramClass, paramObject);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 2290 */   private static final Pointer PLACEHOLDER_MEMORY = new Pointer(0L) {
/*      */       public Pointer share(long param1Long1, long param1Long2) {
/* 2292 */         return this;
/*      */       }
/*      */     };
/*      */ 
/*      */ 
/*      */   
/*      */   static void validate(Class<? extends Structure> paramClass) {
/*      */     try {
/* 2300 */       paramClass.getConstructor(new Class[0]);
/*      */       return;
/* 2302 */     } catch (NoSuchMethodException noSuchMethodException) {
/*      */     
/* 2304 */     } catch (SecurityException securityException) {}
/*      */     
/* 2306 */     throw new IllegalArgumentException("No suitable constructor found for class: " + paramClass.getName());
/*      */   }
/*      */   
/*      */   @Documented
/*      */   @Retention(RetentionPolicy.RUNTIME)
/*      */   @Target({ElementType.TYPE})
/*      */   public static @interface FieldOrder {
/*      */     String[] value();
/*      */   }
/*      */   
/*      */   public static interface ByReference {}
/*      */   
/*      */   public static interface ByValue {}
/*      */ }


/* Location:              C:\Arremate\Arremate.jar!\com\sun\jna\Structure.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */