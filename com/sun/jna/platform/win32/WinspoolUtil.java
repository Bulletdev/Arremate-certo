/*     */ package com.sun.jna.platform.win32;
/*     */ 
/*     */ import com.sun.jna.ptr.IntByReference;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class WinspoolUtil
/*     */ {
/*     */   public static Winspool.PRINTER_INFO_1[] getPrinterInfo1() {
/*  44 */     IntByReference intByReference1 = new IntByReference();
/*  45 */     IntByReference intByReference2 = new IntByReference();
/*  46 */     Winspool.INSTANCE.EnumPrinters(2, null, 1, null, 0, intByReference1, intByReference2);
/*     */     
/*  48 */     if (intByReference1.getValue() <= 0) {
/*  49 */       return new Winspool.PRINTER_INFO_1[0];
/*     */     }
/*     */     
/*  52 */     Winspool.PRINTER_INFO_1 pRINTER_INFO_1 = new Winspool.PRINTER_INFO_1(intByReference1.getValue());
/*  53 */     if (!Winspool.INSTANCE.EnumPrinters(2, null, 1, pRINTER_INFO_1
/*  54 */         .getPointer(), intByReference1.getValue(), intByReference1, intByReference2))
/*     */     {
/*  56 */       throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
/*     */     }
/*     */     
/*  59 */     pRINTER_INFO_1.read();
/*     */     
/*  61 */     return (Winspool.PRINTER_INFO_1[])pRINTER_INFO_1.toArray(intByReference2.getValue());
/*     */   }
/*     */   
/*     */   public static Winspool.PRINTER_INFO_2[] getPrinterInfo2() {
/*  65 */     return getPrinterInfo2(2);
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
/*     */   public static Winspool.PRINTER_INFO_2[] getAllPrinterInfo2() {
/*  78 */     return getPrinterInfo2(6);
/*     */   }
/*     */   
/*     */   private static Winspool.PRINTER_INFO_2[] getPrinterInfo2(int paramInt) {
/*  82 */     IntByReference intByReference1 = new IntByReference();
/*  83 */     IntByReference intByReference2 = new IntByReference();
/*  84 */     Winspool.INSTANCE.EnumPrinters(paramInt, null, 2, null, 0, intByReference1, intByReference2);
/*  85 */     if (intByReference1.getValue() <= 0) {
/*  86 */       return new Winspool.PRINTER_INFO_2[0];
/*     */     }
/*     */     
/*  89 */     Winspool.PRINTER_INFO_2 pRINTER_INFO_2 = new Winspool.PRINTER_INFO_2(intByReference1.getValue());
/*  90 */     if (!Winspool.INSTANCE.EnumPrinters(paramInt, null, 2, pRINTER_INFO_2.getPointer(), intByReference1.getValue(), intByReference1, intByReference2))
/*     */     {
/*  92 */       throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
/*     */     }
/*     */     
/*  95 */     pRINTER_INFO_2.read();
/*  96 */     return (Winspool.PRINTER_INFO_2[])pRINTER_INFO_2.toArray(intByReference2.getValue());
/*     */   }
/*     */   public static Winspool.PRINTER_INFO_2 getPrinterInfo2(String paramString) {
/*     */     Win32Exception win32Exception;
/* 100 */     IntByReference intByReference1 = new IntByReference();
/* 101 */     IntByReference intByReference2 = new IntByReference();
/* 102 */     WinNT.HANDLEByReference hANDLEByReference = new WinNT.HANDLEByReference();
/*     */     
/* 104 */     if (!Winspool.INSTANCE.OpenPrinter(paramString, hANDLEByReference, null)) {
/* 105 */       throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
/*     */     }
/*     */     
/* 108 */     Throwable throwable = null;
/* 109 */     Winspool.PRINTER_INFO_2 pRINTER_INFO_2 = null;
/*     */     
/*     */     try {
/* 112 */       Winspool.INSTANCE.GetPrinter(hANDLEByReference.getValue(), 2, null, 0, intByReference1);
/* 113 */       if (intByReference1.getValue() <= 0) {
/* 114 */         return new Winspool.PRINTER_INFO_2();
/*     */       }
/*     */       
/* 117 */       pRINTER_INFO_2 = new Winspool.PRINTER_INFO_2(intByReference1.getValue());
/* 118 */       if (!Winspool.INSTANCE.GetPrinter(hANDLEByReference.getValue(), 2, pRINTER_INFO_2.getPointer(), intByReference1.getValue(), intByReference2)) {
/* 119 */         throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
/*     */       }
/*     */       
/* 122 */       pRINTER_INFO_2.read();
/* 123 */     } catch (Win32Exception win32Exception1) {
/* 124 */       win32Exception = win32Exception1;
/*     */     } finally {
/* 126 */       if (!Winspool.INSTANCE.ClosePrinter(hANDLEByReference.getValue())) {
/* 127 */         Win32Exception win32Exception1 = new Win32Exception(Kernel32.INSTANCE.GetLastError());
/* 128 */         if (win32Exception != null) {
/* 129 */           win32Exception1.addSuppressedReflected((Throwable)win32Exception);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 134 */     if (win32Exception != null) {
/* 135 */       throw win32Exception;
/*     */     }
/*     */     
/* 138 */     return pRINTER_INFO_2;
/*     */   }
/*     */   
/*     */   public static Winspool.PRINTER_INFO_4[] getPrinterInfo4() {
/* 142 */     IntByReference intByReference1 = new IntByReference();
/* 143 */     IntByReference intByReference2 = new IntByReference();
/* 144 */     Winspool.INSTANCE.EnumPrinters(2, null, 4, null, 0, intByReference1, intByReference2);
/*     */     
/* 146 */     if (intByReference1.getValue() <= 0) {
/* 147 */       return new Winspool.PRINTER_INFO_4[0];
/*     */     }
/*     */     
/* 150 */     Winspool.PRINTER_INFO_4 pRINTER_INFO_4 = new Winspool.PRINTER_INFO_4(intByReference1.getValue());
/* 151 */     if (!Winspool.INSTANCE.EnumPrinters(2, null, 4, pRINTER_INFO_4
/* 152 */         .getPointer(), intByReference1.getValue(), intByReference1, intByReference2))
/*     */     {
/* 154 */       throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
/*     */     }
/*     */     
/* 157 */     pRINTER_INFO_4.read();
/*     */     
/* 159 */     return (Winspool.PRINTER_INFO_4[])pRINTER_INFO_4.toArray(intByReference2.getValue());
/*     */   }
/*     */   
/*     */   public static Winspool.JOB_INFO_1[] getJobInfo1(WinNT.HANDLEByReference paramHANDLEByReference) {
/* 163 */     IntByReference intByReference1 = new IntByReference();
/* 164 */     IntByReference intByReference2 = new IntByReference();
/* 165 */     Winspool.INSTANCE.EnumJobs(paramHANDLEByReference.getValue(), 0, 255, 1, null, 0, intByReference1, intByReference2);
/*     */     
/* 167 */     if (intByReference1.getValue() <= 0) {
/* 168 */       return new Winspool.JOB_INFO_1[0];
/*     */     }
/*     */     
/* 171 */     int i = 0;
/*     */     
/*     */     while (true) {
/* 174 */       Winspool.JOB_INFO_1 jOB_INFO_1 = new Winspool.JOB_INFO_1(intByReference1.getValue());
/* 175 */       if (!Winspool.INSTANCE.EnumJobs(paramHANDLEByReference.getValue(), 0, 255, 1, jOB_INFO_1
/* 176 */           .getPointer(), intByReference1.getValue(), intByReference1, intByReference2))
/*     */       {
/* 178 */         i = Kernel32.INSTANCE.GetLastError();
/*     */       }
/* 180 */       if (i != 122) {
/* 181 */         if (i != 0) {
/* 182 */           throw new Win32Exception(i);
/*     */         }
/* 184 */         if (intByReference2.getValue() <= 0) {
/* 185 */           return new Winspool.JOB_INFO_1[0];
/*     */         }
/*     */         
/* 188 */         jOB_INFO_1.read();
/*     */         
/* 190 */         return (Winspool.JOB_INFO_1[])jOB_INFO_1.toArray(intByReference2.getValue());
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\sun\jna\platform\win32\WinspoolUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */