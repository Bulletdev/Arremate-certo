/*     */ package com.sun.jna.platform.win32;
/*     */ 
/*     */ import com.sun.jna.Memory;
/*     */ import com.sun.jna.Native;
/*     */ import com.sun.jna.Pointer;
/*     */ import com.sun.jna.ptr.IntByReference;
/*     */ import com.sun.jna.win32.W32APITypeMapper;
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
/*     */ public abstract class Cfgmgr32Util
/*     */ {
/*     */   public static class Cfgmgr32Exception
/*     */     extends RuntimeException
/*     */   {
/*     */     private final int errorCode;
/*     */     
/*     */     public Cfgmgr32Exception(int param1Int) {
/*  40 */       this.errorCode = param1Int;
/*     */     }
/*     */     
/*     */     public int getErrorCode() {
/*  44 */       return this.errorCode;
/*     */     }
/*     */ 
/*     */     
/*     */     public String toString() {
/*  49 */       return super.toString() + String.format(" [errorCode: 0x%08x]", new Object[] { Integer.valueOf(this.errorCode) });
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
/*     */   public static String CM_Get_Device_ID(int paramInt) throws Cfgmgr32Exception {
/*  65 */     byte b = Boolean.getBoolean("w32.ascii") ? 1 : Native.WCHAR_SIZE;
/*     */ 
/*     */     
/*  68 */     IntByReference intByReference = new IntByReference();
/*  69 */     int i = Cfgmgr32.INSTANCE.CM_Get_Device_ID_Size(intByReference, paramInt, 0);
/*  70 */     if (i != 0) {
/*  71 */       throw new Cfgmgr32Exception(i);
/*     */     }
/*     */ 
/*     */     
/*  75 */     Memory memory = new Memory(((intByReference.getValue() + 1) * b));
/*     */     
/*  77 */     memory.clear();
/*     */     
/*  79 */     i = Cfgmgr32.INSTANCE.CM_Get_Device_ID(paramInt, (Pointer)memory, intByReference.getValue(), 0);
/*     */ 
/*     */ 
/*     */     
/*  83 */     if (i == 26) {
/*  84 */       i = Cfgmgr32.INSTANCE.CM_Get_Device_ID_Size(intByReference, paramInt, 0);
/*  85 */       if (i != 0) {
/*  86 */         throw new Cfgmgr32Exception(i);
/*     */       }
/*  88 */       memory = new Memory(((intByReference.getValue() + 1) * b));
/*  89 */       memory.clear();
/*  90 */       i = Cfgmgr32.INSTANCE.CM_Get_Device_ID(paramInt, (Pointer)memory, intByReference.getValue(), 0);
/*     */     } 
/*     */     
/*  93 */     if (i != 0) {
/*  94 */       throw new Cfgmgr32Exception(i);
/*     */     }
/*     */     
/*  97 */     if (b == 1) {
/*  98 */       return memory.getString(0L);
/*     */     }
/* 100 */     return memory.getWideString(0L);
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
/*     */   public static Object CM_Get_DevNode_Registry_Property(int paramInt1, int paramInt2) throws Cfgmgr32Exception {
/* 139 */     IntByReference intByReference1 = new IntByReference();
/* 140 */     IntByReference intByReference2 = new IntByReference();
/* 141 */     int i = Cfgmgr32.INSTANCE.CM_Get_DevNode_Registry_Property(paramInt1, paramInt2, intByReference2, null, intByReference1, 0);
/*     */     
/* 143 */     if (i == 37) {
/* 144 */       return null;
/*     */     }
/*     */ 
/*     */     
/* 148 */     if (i != 26) {
/* 149 */       throw new Cfgmgr32Exception(i);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 154 */     Memory memory = null;
/* 155 */     if (intByReference1.getValue() > 0) {
/* 156 */       memory = new Memory(intByReference1.getValue());
/* 157 */       i = Cfgmgr32.INSTANCE.CM_Get_DevNode_Registry_Property(paramInt1, paramInt2, intByReference2, (Pointer)memory, intByReference1, 0);
/* 158 */       if (i != 0) {
/* 159 */         throw new Cfgmgr32Exception(i);
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 164 */     switch (intByReference2.getValue()) {
/*     */       
/*     */       case 1:
/* 167 */         if (memory == null) {
/* 168 */           return "";
/*     */         }
/* 170 */         return (W32APITypeMapper.DEFAULT == W32APITypeMapper.UNICODE) ? memory.getWideString(0L) : memory
/* 171 */           .getString(0L);
/*     */       
/*     */       case 7:
/* 174 */         if (memory == null) {
/* 175 */           return new String[0];
/*     */         }
/* 177 */         return Advapi32Util.regMultiSzBufferToStringArray(memory);
/*     */       
/*     */       case 4:
/* 180 */         if (memory == null) {
/* 181 */           return Integer.valueOf(0);
/*     */         }
/* 183 */         return Integer.valueOf(memory.getInt(0L));
/*     */       case 0:
/* 185 */         return null;
/*     */     } 
/*     */     
/* 188 */     if (memory == null) {
/* 189 */       return new byte[0];
/*     */     }
/*     */     
/* 192 */     return memory.getByteArray(0L, (int)memory.size());
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\sun\jna\platform\win32\Cfgmgr32Util.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */