/*     */ package com.sun.jna;
/*     */ 
/*     */ import java.lang.reflect.Method;
/*     */ import java.util.Collections;
/*     */ import java.util.Map;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Function
/*     */   extends Pointer
/*     */ {
/*     */   public static final int MAX_NARGS = 256;
/*     */   public static final int C_CONVENTION = 0;
/*     */   public static final int ALT_CONVENTION = 63;
/*     */   private static final int MASK_CC = 63;
/*     */   public static final int THROW_LAST_ERROR = 64;
/*     */   public static final int USE_VARARGS = 384;
/*  83 */   static final Integer INTEGER_TRUE = Integer.valueOf(-1);
/*  84 */   static final Integer INTEGER_FALSE = Integer.valueOf(0);
/*     */ 
/*     */   
/*     */   private NativeLibrary library;
/*     */ 
/*     */   
/*     */   private final String functionName;
/*     */   
/*     */   final String encoding;
/*     */   
/*     */   final int callFlags;
/*     */   
/*     */   final Map<String, ?> options;
/*     */   
/*     */   static final String OPTION_INVOKING_METHOD = "invoking-method";
/*     */ 
/*     */   
/*     */   public static Function getFunction(String paramString1, String paramString2) {
/* 102 */     return NativeLibrary.getInstance(paramString1).getFunction(paramString2);
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
/*     */   public static Function getFunction(String paramString1, String paramString2, int paramInt) {
/* 123 */     return NativeLibrary.getInstance(paramString1).getFunction(paramString2, paramInt, null);
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
/*     */   public static Function getFunction(String paramString1, String paramString2, int paramInt, String paramString3) {
/* 147 */     return NativeLibrary.getInstance(paramString1).getFunction(paramString2, paramInt, paramString3);
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
/*     */   public static Function getFunction(Pointer paramPointer) {
/* 162 */     return getFunction(paramPointer, 0, (String)null);
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
/*     */   public static Function getFunction(Pointer paramPointer, int paramInt) {
/* 180 */     return getFunction(paramPointer, paramInt, (String)null);
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
/*     */   public static Function getFunction(Pointer paramPointer, int paramInt, String paramString) {
/* 201 */     return new Function(paramPointer, paramInt, paramString);
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
/* 216 */   private static final VarArgsChecker IS_VARARGS = VarArgsChecker.create();
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
/*     */   Function(NativeLibrary paramNativeLibrary, String paramString1, int paramInt, String paramString2) {
/* 238 */     checkCallingConvention(paramInt & 0x3F);
/* 239 */     if (paramString1 == null) {
/* 240 */       throw new NullPointerException("Function name must not be null");
/*     */     }
/* 242 */     this.library = paramNativeLibrary;
/* 243 */     this.functionName = paramString1;
/* 244 */     this.callFlags = paramInt;
/* 245 */     this.options = paramNativeLibrary.options;
/* 246 */     this.encoding = (paramString2 != null) ? paramString2 : Native.getDefaultStringEncoding();
/*     */     try {
/* 248 */       this.peer = paramNativeLibrary.getSymbolAddress(paramString1);
/* 249 */     } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 250 */       throw new UnsatisfiedLinkError("Error looking up function '" + paramString1 + "': " + unsatisfiedLinkError
/*     */           
/* 252 */           .getMessage());
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
/*     */   Function(Pointer paramPointer, int paramInt, String paramString) {
/* 272 */     checkCallingConvention(paramInt & 0x3F);
/* 273 */     if (paramPointer == null || paramPointer.peer == 0L)
/*     */     {
/* 275 */       throw new NullPointerException("Function address may not be null");
/*     */     }
/* 277 */     this.functionName = paramPointer.toString();
/* 278 */     this.callFlags = paramInt;
/* 279 */     this.peer = paramPointer.peer;
/* 280 */     this.options = Collections.EMPTY_MAP;
/* 281 */     this
/* 282 */       .encoding = (paramString != null) ? paramString : Native.getDefaultStringEncoding();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void checkCallingConvention(int paramInt) throws IllegalArgumentException {
/* 288 */     if ((paramInt & 0x3F) != paramInt) {
/* 289 */       throw new IllegalArgumentException("Unrecognized calling convention: " + paramInt);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getName() {
/* 295 */     return this.functionName;
/*     */   }
/*     */   
/*     */   public int getCallingConvention() {
/* 299 */     return this.callFlags & 0x3F;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Object invoke(Class<?> paramClass, Object[] paramArrayOfObject) {
/* 306 */     return invoke(paramClass, paramArrayOfObject, this.options);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Object invoke(Class<?> paramClass, Object[] paramArrayOfObject, Map<String, ?> paramMap) {
/* 313 */     Method method = (Method)paramMap.get("invoking-method");
/* 314 */     Class<?>[] arrayOfClass = (method != null) ? method.getParameterTypes() : null;
/* 315 */     return invoke(method, arrayOfClass, paramClass, paramArrayOfObject, paramMap);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   Object invoke(Method paramMethod, Class<?>[] paramArrayOfClass, Class<?> paramClass, Object[] paramArrayOfObject, Map<String, ?> paramMap) {
/* 326 */     Object[] arrayOfObject = new Object[0];
/* 327 */     if (paramArrayOfObject != null) {
/* 328 */       if (paramArrayOfObject.length > 256) {
/* 329 */         throw new UnsupportedOperationException("Maximum argument count is 256");
/*     */       }
/* 331 */       arrayOfObject = new Object[paramArrayOfObject.length];
/* 332 */       System.arraycopy(paramArrayOfObject, 0, arrayOfObject, 0, arrayOfObject.length);
/*     */     } 
/*     */     
/* 335 */     TypeMapper typeMapper = (TypeMapper)paramMap.get("type-mapper");
/* 336 */     boolean bool = Boolean.TRUE.equals(paramMap.get("allow-objects"));
/* 337 */     boolean bool1 = (arrayOfObject.length > 0 && paramMethod != null) ? isVarArgs(paramMethod) : false;
/* 338 */     boolean bool2 = (arrayOfObject.length > 0 && paramMethod != null) ? fixedArgs(paramMethod) : false;
/* 339 */     for (byte b = 0; b < arrayOfObject.length; b++) {
/*     */ 
/*     */       
/* 342 */       Class<?> clazz1 = (paramMethod != null) ? ((bool1 && b >= paramArrayOfClass.length - 1) ? paramArrayOfClass[paramArrayOfClass.length - 1].getComponentType() : paramArrayOfClass[b]) : null;
/*     */ 
/*     */       
/* 345 */       arrayOfObject[b] = convertArgument(arrayOfObject, b, paramMethod, typeMapper, bool, clazz1);
/*     */     } 
/*     */     
/* 348 */     Class<?> clazz = paramClass;
/* 349 */     FromNativeConverter fromNativeConverter = null;
/* 350 */     if (NativeMapped.class.isAssignableFrom(paramClass)) {
/* 351 */       NativeMappedConverter nativeMappedConverter = NativeMappedConverter.getInstance(paramClass);
/* 352 */       fromNativeConverter = nativeMappedConverter;
/* 353 */       clazz = nativeMappedConverter.nativeType();
/* 354 */     } else if (typeMapper != null) {
/* 355 */       fromNativeConverter = typeMapper.getFromNativeConverter(paramClass);
/* 356 */       if (fromNativeConverter != null) {
/* 357 */         clazz = fromNativeConverter.nativeType();
/*     */       }
/*     */     } 
/*     */     
/* 361 */     Object object = invoke(arrayOfObject, clazz, bool, bool2);
/*     */     
/* 363 */     if (fromNativeConverter != null) {
/*     */       FunctionResultContext functionResultContext;
/* 365 */       if (paramMethod != null) {
/* 366 */         functionResultContext = new MethodResultContext(paramClass, this, paramArrayOfObject, paramMethod);
/*     */       } else {
/* 368 */         functionResultContext = new FunctionResultContext(paramClass, this, paramArrayOfObject);
/*     */       } 
/* 370 */       object = fromNativeConverter.fromNative(object, functionResultContext);
/*     */     } 
/*     */ 
/*     */     
/* 374 */     if (paramArrayOfObject != null) {
/* 375 */       for (byte b1 = 0; b1 < paramArrayOfObject.length; b1++) {
/* 376 */         Object object1 = paramArrayOfObject[b1];
/* 377 */         if (object1 != null)
/*     */         {
/* 379 */           if (object1 instanceof Structure) {
/* 380 */             if (!(object1 instanceof Structure.ByValue)) {
/* 381 */               ((Structure)object1).autoRead();
/*     */             }
/* 383 */           } else if (arrayOfObject[b1] instanceof PostCallRead) {
/* 384 */             ((PostCallRead)arrayOfObject[b1]).read();
/* 385 */             if (arrayOfObject[b1] instanceof PointerArray) {
/* 386 */               PointerArray pointerArray = (PointerArray)arrayOfObject[b1];
/* 387 */               if (Structure.ByReference[].class.isAssignableFrom(object1.getClass())) {
/* 388 */                 Class<?> clazz1 = object1.getClass().getComponentType();
/* 389 */                 Structure[] arrayOfStructure = (Structure[])object1;
/* 390 */                 for (byte b2 = 0; b2 < arrayOfStructure.length; b2++) {
/* 391 */                   Pointer pointer = pointerArray.getPointer((Native.POINTER_SIZE * b2));
/* 392 */                   arrayOfStructure[b2] = Structure.updateStructureByReference(clazz1, arrayOfStructure[b2], pointer);
/*     */                 } 
/*     */               } 
/*     */             } 
/* 396 */           } else if (Structure[].class.isAssignableFrom(object1.getClass())) {
/* 397 */             Structure.autoRead((Structure[])object1);
/*     */           } 
/*     */         }
/*     */       } 
/*     */     }
/* 402 */     return object;
/*     */   }
/*     */ 
/*     */   
/*     */   Object invoke(Object[] paramArrayOfObject, Class<?> paramClass, boolean paramBoolean) {
/* 407 */     return invoke(paramArrayOfObject, paramClass, paramBoolean, 0);
/*     */   }
/*     */ 
/*     */   
/*     */   Object invoke(Object[] paramArrayOfObject, Class<?> paramClass, boolean paramBoolean, int paramInt) {
/* 412 */     Object object = null;
/* 413 */     int i = this.callFlags | (paramInt & 0x3) << 7;
/* 414 */     if (paramClass == null || paramClass == void.class || paramClass == Void.class) {
/* 415 */       Native.invokeVoid(this, this.peer, i, paramArrayOfObject);
/* 416 */       object = null;
/* 417 */     } else if (paramClass == boolean.class || paramClass == Boolean.class) {
/* 418 */       object = valueOf((Native.invokeInt(this, this.peer, i, paramArrayOfObject) != 0));
/* 419 */     } else if (paramClass == byte.class || paramClass == Byte.class) {
/* 420 */       Byte byte_ = Byte.valueOf((byte)Native.invokeInt(this, this.peer, i, paramArrayOfObject));
/* 421 */     } else if (paramClass == short.class || paramClass == Short.class) {
/* 422 */       Short short_ = Short.valueOf((short)Native.invokeInt(this, this.peer, i, paramArrayOfObject));
/* 423 */     } else if (paramClass == char.class || paramClass == Character.class) {
/* 424 */       Character character = Character.valueOf((char)Native.invokeInt(this, this.peer, i, paramArrayOfObject));
/* 425 */     } else if (paramClass == int.class || paramClass == Integer.class) {
/* 426 */       Integer integer = Integer.valueOf(Native.invokeInt(this, this.peer, i, paramArrayOfObject));
/* 427 */     } else if (paramClass == long.class || paramClass == Long.class) {
/* 428 */       Long long_ = Long.valueOf(Native.invokeLong(this, this.peer, i, paramArrayOfObject));
/* 429 */     } else if (paramClass == float.class || paramClass == Float.class) {
/* 430 */       Float float_ = Float.valueOf(Native.invokeFloat(this, this.peer, i, paramArrayOfObject));
/* 431 */     } else if (paramClass == double.class || paramClass == Double.class) {
/* 432 */       Double double_ = Double.valueOf(Native.invokeDouble(this, this.peer, i, paramArrayOfObject));
/* 433 */     } else if (paramClass == String.class) {
/* 434 */       String str = invokeString(i, paramArrayOfObject, false);
/* 435 */     } else if (paramClass == WString.class) {
/* 436 */       String str = invokeString(i, paramArrayOfObject, true);
/* 437 */       if (str != null)
/* 438 */         WString wString = new WString(str); 
/*     */     } else {
/* 440 */       if (Pointer.class.isAssignableFrom(paramClass))
/* 441 */         return invokePointer(i, paramArrayOfObject); 
/* 442 */       if (Structure.class.isAssignableFrom(paramClass)) {
/* 443 */         if (Structure.ByValue.class.isAssignableFrom(paramClass)) {
/*     */           
/* 445 */           Structure structure2 = Native.invokeStructure(this, this.peer, i, paramArrayOfObject, 
/* 446 */               (Structure)Structure.newInstance(paramClass));
/* 447 */           structure2.autoRead();
/* 448 */           Structure structure1 = structure2;
/*     */         } else {
/* 450 */           Pointer pointer = invokePointer(i, paramArrayOfObject);
/* 451 */           if (pointer != null) {
/* 452 */             Structure structure2 = (Structure)Structure.newInstance((Class)paramClass, pointer);
/* 453 */             structure2.conditionalAutoRead();
/* 454 */             Structure structure1 = structure2;
/*     */           } 
/*     */         } 
/* 457 */       } else if (Callback.class.isAssignableFrom(paramClass)) {
/* 458 */         Pointer pointer = invokePointer(i, paramArrayOfObject);
/* 459 */         if (pointer != null) {
/* 460 */           Callback callback = CallbackReference.getCallback(paramClass, pointer);
/*     */         }
/* 462 */       } else if (paramClass == String[].class) {
/* 463 */         Pointer pointer = invokePointer(i, paramArrayOfObject);
/* 464 */         if (pointer != null) {
/* 465 */           String[] arrayOfString = pointer.getStringArray(0L, this.encoding);
/*     */         }
/* 467 */       } else if (paramClass == WString[].class) {
/* 468 */         Pointer pointer = invokePointer(i, paramArrayOfObject);
/* 469 */         if (pointer != null) {
/* 470 */           String[] arrayOfString = pointer.getWideStringArray(0L);
/* 471 */           WString[] arrayOfWString2 = new WString[arrayOfString.length];
/* 472 */           for (byte b = 0; b < arrayOfString.length; b++) {
/* 473 */             arrayOfWString2[b] = new WString(arrayOfString[b]);
/*     */           }
/* 475 */           WString[] arrayOfWString1 = arrayOfWString2;
/*     */         } 
/* 477 */       } else if (paramClass == Pointer[].class) {
/* 478 */         Pointer pointer = invokePointer(i, paramArrayOfObject);
/* 479 */         if (pointer != null) {
/* 480 */           Pointer[] arrayOfPointer = pointer.getPointerArray(0L);
/*     */         }
/* 482 */       } else if (paramBoolean) {
/* 483 */         object = Native.invokeObject(this, this.peer, i, paramArrayOfObject);
/* 484 */         if (object != null && 
/* 485 */           !paramClass.isAssignableFrom(object.getClass())) {
/* 486 */           throw new ClassCastException("Return type " + paramClass + " does not match result " + object
/*     */               
/* 488 */               .getClass());
/*     */         }
/*     */       } else {
/* 491 */         throw new IllegalArgumentException("Unsupported return type " + paramClass + " in function " + getName());
/*     */       } 
/* 493 */     }  return object;
/*     */   }
/*     */   
/*     */   private Pointer invokePointer(int paramInt, Object[] paramArrayOfObject) {
/* 497 */     long l = Native.invokePointer(this, this.peer, paramInt, paramArrayOfObject);
/* 498 */     return (l == 0L) ? null : new Pointer(l);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private Object convertArgument(Object[] paramArrayOfObject, int paramInt, Method paramMethod, TypeMapper paramTypeMapper, boolean paramBoolean, Class<?> paramClass) {
/* 504 */     Object object = paramArrayOfObject[paramInt];
/* 505 */     if (object != null) {
/* 506 */       Class<?> clazz1 = object.getClass();
/* 507 */       ToNativeConverter toNativeConverter = null;
/* 508 */       if (NativeMapped.class.isAssignableFrom(clazz1)) {
/* 509 */         toNativeConverter = NativeMappedConverter.getInstance(clazz1);
/* 510 */       } else if (paramTypeMapper != null) {
/* 511 */         toNativeConverter = paramTypeMapper.getToNativeConverter(clazz1);
/*     */       } 
/* 513 */       if (toNativeConverter != null) {
/*     */         FunctionParameterContext functionParameterContext;
/* 515 */         if (paramMethod != null) {
/* 516 */           functionParameterContext = new MethodParameterContext(this, paramArrayOfObject, paramInt, paramMethod);
/*     */         } else {
/*     */           
/* 519 */           functionParameterContext = new FunctionParameterContext(this, paramArrayOfObject, paramInt);
/*     */         } 
/* 521 */         object = toNativeConverter.toNative(object, functionParameterContext);
/*     */       } 
/*     */     } 
/* 524 */     if (object == null || isPrimitiveArray(object.getClass())) {
/* 525 */       return object;
/*     */     }
/*     */     
/* 528 */     Class<?> clazz = object.getClass();
/*     */     
/* 530 */     if (object instanceof Structure) {
/* 531 */       Structure structure = (Structure)object;
/* 532 */       structure.autoWrite();
/* 533 */       if (structure instanceof Structure.ByValue) {
/*     */         
/* 535 */         Class<?> clazz1 = structure.getClass();
/* 536 */         if (paramMethod != null) {
/* 537 */           Class[] arrayOfClass = paramMethod.getParameterTypes();
/* 538 */           if (IS_VARARGS.isVarArgs(paramMethod)) {
/* 539 */             if (paramInt < arrayOfClass.length - 1) {
/* 540 */               clazz1 = arrayOfClass[paramInt];
/*     */             } else {
/* 542 */               Class<?> clazz2 = arrayOfClass[arrayOfClass.length - 1].getComponentType();
/* 543 */               if (clazz2 != Object.class) {
/* 544 */                 clazz1 = clazz2;
/*     */               }
/*     */             } 
/*     */           } else {
/* 548 */             clazz1 = arrayOfClass[paramInt];
/*     */           } 
/*     */         } 
/* 551 */         if (Structure.ByValue.class.isAssignableFrom(clazz1)) {
/* 552 */           return structure;
/*     */         }
/*     */       } 
/* 555 */       return structure.getPointer();
/* 556 */     }  if (object instanceof Callback)
/*     */     {
/* 558 */       return CallbackReference.getFunctionPointer((Callback)object); } 
/* 559 */     if (object instanceof String)
/*     */     {
/*     */ 
/*     */ 
/*     */       
/* 564 */       return (new NativeString((String)object, false)).getPointer(); } 
/* 565 */     if (object instanceof WString)
/*     */     {
/* 567 */       return (new NativeString(object.toString(), true)).getPointer(); } 
/* 568 */     if (object instanceof Boolean)
/*     */     {
/*     */       
/* 571 */       return Boolean.TRUE.equals(object) ? INTEGER_TRUE : INTEGER_FALSE; } 
/* 572 */     if (String[].class == clazz)
/* 573 */       return new StringArray((String[])object, this.encoding); 
/* 574 */     if (WString[].class == clazz)
/* 575 */       return new StringArray((WString[])object); 
/* 576 */     if (Pointer[].class == clazz)
/* 577 */       return new PointerArray((Pointer[])object); 
/* 578 */     if (NativeMapped[].class.isAssignableFrom(clazz))
/* 579 */       return new NativeMappedArray((NativeMapped[])object); 
/* 580 */     if (Structure[].class.isAssignableFrom(clazz)) {
/*     */ 
/*     */       
/* 583 */       Structure[] arrayOfStructure = (Structure[])object;
/* 584 */       Class<?> clazz1 = clazz.getComponentType();
/* 585 */       boolean bool = Structure.ByReference.class.isAssignableFrom(clazz1);
/* 586 */       if (paramClass != null && 
/* 587 */         !Structure.ByReference[].class.isAssignableFrom(paramClass)) {
/* 588 */         if (bool) {
/* 589 */           throw new IllegalArgumentException("Function " + getName() + " declared Structure[] at parameter " + paramInt + " but array of " + clazz1 + " was passed");
/*     */         }
/*     */ 
/*     */ 
/*     */         
/* 594 */         for (byte b = 0; b < arrayOfStructure.length; b++) {
/* 595 */           if (arrayOfStructure[b] instanceof Structure.ByReference) {
/* 596 */             throw new IllegalArgumentException("Function " + getName() + " declared Structure[] at parameter " + paramInt + " but element " + b + " is of Structure.ByReference type");
/*     */           }
/*     */         } 
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 604 */       if (bool) {
/* 605 */         Structure.autoWrite(arrayOfStructure);
/* 606 */         Pointer[] arrayOfPointer = new Pointer[arrayOfStructure.length + 1];
/* 607 */         for (byte b = 0; b < arrayOfStructure.length; b++) {
/* 608 */           arrayOfPointer[b] = (arrayOfStructure[b] != null) ? arrayOfStructure[b].getPointer() : null;
/*     */         }
/* 610 */         return new PointerArray(arrayOfPointer);
/* 611 */       }  if (arrayOfStructure.length == 0)
/* 612 */         throw new IllegalArgumentException("Structure array must have non-zero length"); 
/* 613 */       if (arrayOfStructure[0] == null) {
/* 614 */         Structure.newInstance(clazz1).toArray(arrayOfStructure);
/* 615 */         return arrayOfStructure[0].getPointer();
/*     */       } 
/* 617 */       Structure.autoWrite(arrayOfStructure);
/* 618 */       return arrayOfStructure[0].getPointer();
/*     */     } 
/* 620 */     if (clazz.isArray())
/* 621 */       throw new IllegalArgumentException("Unsupported array argument type: " + clazz
/* 622 */           .getComponentType()); 
/* 623 */     if (paramBoolean)
/* 624 */       return object; 
/* 625 */     if (!Native.isSupportedNativeType(object.getClass())) {
/* 626 */       throw new IllegalArgumentException("Unsupported argument type " + object
/* 627 */           .getClass().getName() + " at parameter " + paramInt + " of function " + 
/*     */           
/* 629 */           getName());
/*     */     }
/* 631 */     return object;
/*     */   }
/*     */   
/*     */   private boolean isPrimitiveArray(Class<?> paramClass) {
/* 635 */     return (paramClass.isArray() && paramClass
/* 636 */       .getComponentType().isPrimitive());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void invoke(Object[] paramArrayOfObject) {
/* 645 */     invoke(Void.class, paramArrayOfObject);
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
/*     */   private String invokeString(int paramInt, Object[] paramArrayOfObject, boolean paramBoolean) {
/* 660 */     Pointer pointer = invokePointer(paramInt, paramArrayOfObject);
/* 661 */     String str = null;
/* 662 */     if (pointer != null) {
/* 663 */       if (paramBoolean) {
/* 664 */         str = pointer.getWideString(0L);
/*     */       } else {
/*     */         
/* 667 */         str = pointer.getString(0L, this.encoding);
/*     */       } 
/*     */     }
/* 670 */     return str;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 676 */     if (this.library != null) {
/* 677 */       return "native function " + this.functionName + "(" + this.library.getName() + ")@0x" + 
/* 678 */         Long.toHexString(this.peer);
/*     */     }
/* 680 */     return "native function@0x" + Long.toHexString(this.peer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Object invokeObject(Object[] paramArrayOfObject) {
/* 687 */     return invoke(Object.class, paramArrayOfObject);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Pointer invokePointer(Object[] paramArrayOfObject) {
/* 694 */     return (Pointer)invoke(Pointer.class, paramArrayOfObject);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String invokeString(Object[] paramArrayOfObject, boolean paramBoolean) {
/* 705 */     Object object = invoke(paramBoolean ? WString.class : String.class, paramArrayOfObject);
/* 706 */     return (object != null) ? object.toString() : null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int invokeInt(Object[] paramArrayOfObject) {
/* 713 */     return ((Integer)invoke(Integer.class, paramArrayOfObject)).intValue();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public long invokeLong(Object[] paramArrayOfObject) {
/* 719 */     return ((Long)invoke(Long.class, paramArrayOfObject)).longValue();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public float invokeFloat(Object[] paramArrayOfObject) {
/* 725 */     return ((Float)invoke(Float.class, paramArrayOfObject)).floatValue();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public double invokeDouble(Object[] paramArrayOfObject) {
/* 731 */     return ((Double)invoke(Double.class, paramArrayOfObject)).doubleValue();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void invokeVoid(Object[] paramArrayOfObject) {
/* 737 */     invoke(Void.class, paramArrayOfObject);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 745 */     if (paramObject == this) return true; 
/* 746 */     if (paramObject == null) return false; 
/* 747 */     if (paramObject.getClass() == getClass()) {
/* 748 */       Function function = (Function)paramObject;
/* 749 */       return (function.callFlags == this.callFlags && function.options
/* 750 */         .equals(this.options) && function.peer == this.peer);
/*     */     } 
/*     */     
/* 753 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 761 */     return this.callFlags + this.options.hashCode() + super.hashCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static Object[] concatenateVarArgs(Object[] paramArrayOfObject) {
/* 771 */     if (paramArrayOfObject != null && paramArrayOfObject.length > 0) {
/* 772 */       Object object = paramArrayOfObject[paramArrayOfObject.length - 1];
/* 773 */       Class<?> clazz = (object != null) ? object.getClass() : null;
/* 774 */       if (clazz != null && clazz.isArray()) {
/* 775 */         Object[] arrayOfObject1 = (Object[])object;
/*     */         
/* 777 */         for (byte b = 0; b < arrayOfObject1.length; b++) {
/* 778 */           if (arrayOfObject1[b] instanceof Float) {
/* 779 */             arrayOfObject1[b] = Double.valueOf(((Float)arrayOfObject1[b]).floatValue());
/*     */           }
/*     */         } 
/* 782 */         Object[] arrayOfObject2 = new Object[paramArrayOfObject.length + arrayOfObject1.length];
/* 783 */         System.arraycopy(paramArrayOfObject, 0, arrayOfObject2, 0, paramArrayOfObject.length - 1);
/* 784 */         System.arraycopy(arrayOfObject1, 0, arrayOfObject2, paramArrayOfObject.length - 1, arrayOfObject1.length);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 790 */         arrayOfObject2[arrayOfObject2.length - 1] = null;
/* 791 */         paramArrayOfObject = arrayOfObject2;
/*     */       } 
/*     */     } 
/* 794 */     return paramArrayOfObject;
/*     */   }
/*     */ 
/*     */   
/*     */   static boolean isVarArgs(Method paramMethod) {
/* 799 */     return IS_VARARGS.isVarArgs(paramMethod);
/*     */   }
/*     */ 
/*     */   
/*     */   static int fixedArgs(Method paramMethod) {
/* 804 */     return IS_VARARGS.fixedArgs(paramMethod);
/*     */   }
/*     */   public static interface PostCallRead {
/*     */     void read(); }
/*     */   
/*     */   private static class NativeMappedArray extends Memory implements PostCallRead { public NativeMappedArray(NativeMapped[] param1ArrayOfNativeMapped) {
/* 810 */       super(Native.getNativeSize(param1ArrayOfNativeMapped.getClass(), param1ArrayOfNativeMapped));
/* 811 */       this.original = param1ArrayOfNativeMapped;
/* 812 */       setValue(0L, this.original, this.original.getClass());
/*     */     }
/*     */     private final NativeMapped[] original;
/*     */     public void read() {
/* 816 */       getValue(0L, this.original.getClass(), this.original);
/*     */     } }
/*     */   
/*     */   private static class PointerArray extends Memory implements PostCallRead {
/*     */     private final Pointer[] original;
/*     */     
/*     */     public PointerArray(Pointer[] param1ArrayOfPointer) {
/* 823 */       super((Native.POINTER_SIZE * (param1ArrayOfPointer.length + 1)));
/* 824 */       this.original = param1ArrayOfPointer;
/* 825 */       for (byte b = 0; b < param1ArrayOfPointer.length; b++) {
/* 826 */         setPointer((b * Native.POINTER_SIZE), param1ArrayOfPointer[b]);
/*     */       }
/* 828 */       setPointer((Native.POINTER_SIZE * param1ArrayOfPointer.length), (Pointer)null);
/*     */     }
/*     */     
/*     */     public void read() {
/* 832 */       read(0L, this.original, 0, this.original.length);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   static Boolean valueOf(boolean paramBoolean) {
/* 838 */     return paramBoolean ? Boolean.TRUE : Boolean.FALSE;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\sun\jna\Function.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */