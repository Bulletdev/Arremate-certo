/*     */ package com.sun.jna.platform.win32;
/*     */ 
/*     */ import com.sun.jna.Memory;
/*     */ import com.sun.jna.Native;
/*     */ import com.sun.jna.Pointer;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class PdhUtil
/*     */ {
/*  40 */   private static final int CHAR_TO_BYTES = Boolean.getBoolean("w32.ascii") ? 1 : Native.WCHAR_SIZE;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static final String ENGLISH_COUNTER_KEY = "SOFTWARE\\Microsoft\\Windows NT\\CurrentVersion\\Perflib\\009";
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static final String ENGLISH_COUNTER_VALUE = "Counter";
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String PdhLookupPerfNameByIndex(String paramString, int paramInt) {
/*  63 */     WinDef.DWORDByReference dWORDByReference = new WinDef.DWORDByReference(new WinDef.DWORD(0L));
/*  64 */     int i = Pdh.INSTANCE.PdhLookupPerfNameByIndex(paramString, paramInt, null, dWORDByReference);
/*  65 */     Memory memory = null;
/*     */ 
/*     */     
/*  68 */     if (i != -1073738819) {
/*     */       
/*  70 */       if (i != 0 && i != -2147481646) {
/*  71 */         throw new PdhException(i);
/*     */       }
/*     */       
/*  74 */       if (dWORDByReference.getValue().intValue() < 1) {
/*  75 */         return "";
/*     */       }
/*     */       
/*  78 */       memory = new Memory((dWORDByReference.getValue().intValue() * CHAR_TO_BYTES));
/*  79 */       i = Pdh.INSTANCE.PdhLookupPerfNameByIndex(paramString, paramInt, (Pointer)memory, dWORDByReference);
/*     */     } else {
/*     */       int j;
/*  82 */       for (j = 32; j <= 1024; j *= 2) {
/*  83 */         dWORDByReference = new WinDef.DWORDByReference(new WinDef.DWORD(j));
/*  84 */         memory = new Memory((j * CHAR_TO_BYTES));
/*  85 */         i = Pdh.INSTANCE.PdhLookupPerfNameByIndex(paramString, paramInt, (Pointer)memory, dWORDByReference);
/*  86 */         if (i != -1073738819 && i != -1073738814) {
/*     */           break;
/*     */         }
/*     */       } 
/*     */     } 
/*  91 */     if (i != 0) {
/*  92 */       throw new PdhException(i);
/*     */     }
/*     */ 
/*     */     
/*  96 */     if (CHAR_TO_BYTES == 1) {
/*  97 */       return memory.getString(0L);
/*     */     }
/*  99 */     return memory.getWideString(0L);
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
/*     */   public static int PdhLookupPerfIndexByEnglishName(String paramString) {
/* 115 */     String[] arrayOfString = Advapi32Util.registryGetStringArray(WinReg.HKEY_LOCAL_MACHINE, "SOFTWARE\\Microsoft\\Windows NT\\CurrentVersion\\Perflib\\009", "Counter");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 121 */     for (byte b = 1; b < arrayOfString.length; b += 2) {
/* 122 */       if (arrayOfString[b].equals(paramString)) {
/*     */         try {
/* 124 */           return Integer.parseInt(arrayOfString[b - 1]);
/* 125 */         } catch (NumberFormatException numberFormatException) {
/*     */           
/* 127 */           return 0;
/*     */         } 
/*     */       }
/*     */     } 
/*     */     
/* 132 */     return 0;
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
/*     */   public static PdhEnumObjectItems PdhEnumObjectItems(String paramString1, String paramString2, String paramString3, int paramInt) {
/* 162 */     ArrayList<String> arrayList1 = new ArrayList();
/* 163 */     ArrayList<String> arrayList2 = new ArrayList();
/*     */ 
/*     */     
/* 166 */     WinDef.DWORDByReference dWORDByReference1 = new WinDef.DWORDByReference(new WinDef.DWORD(0L));
/* 167 */     WinDef.DWORDByReference dWORDByReference2 = new WinDef.DWORDByReference(new WinDef.DWORD(0L));
/* 168 */     int i = Pdh.INSTANCE.PdhEnumObjectItems(paramString1, paramString2, paramString3, null, dWORDByReference1, null, dWORDByReference2, paramInt, 0);
/*     */     
/* 170 */     if (i != 0 && i != -2147481646) {
/* 171 */       throw new PdhException(i);
/*     */     }
/*     */     
/* 174 */     Memory memory1 = null;
/* 175 */     Memory memory2 = null;
/*     */     
/* 177 */     if (dWORDByReference1.getValue().intValue() > 0) {
/* 178 */       memory1 = new Memory((dWORDByReference1.getValue().intValue() * CHAR_TO_BYTES));
/*     */     }
/*     */     
/* 181 */     if (dWORDByReference2.getValue().intValue() > 0) {
/* 182 */       memory2 = new Memory((dWORDByReference2.getValue().intValue() * CHAR_TO_BYTES));
/*     */     }
/*     */     
/* 185 */     i = Pdh.INSTANCE.PdhEnumObjectItems(paramString1, paramString2, paramString3, (Pointer)memory1, dWORDByReference1, (Pointer)memory2, dWORDByReference2, paramInt, 0);
/*     */ 
/*     */     
/* 188 */     if (i != 0) {
/* 189 */       throw new PdhException(i);
/*     */     }
/*     */ 
/*     */     
/* 193 */     if (memory1 != null) {
/* 194 */       int j = 0;
/* 195 */       while (j < memory1.size()) {
/* 196 */         String str = null;
/* 197 */         if (CHAR_TO_BYTES == 1) {
/* 198 */           str = memory1.getString(j);
/*     */         } else {
/* 200 */           str = memory1.getWideString(j);
/*     */         } 
/*     */         
/* 203 */         if (str.isEmpty()) {
/*     */           break;
/*     */         }
/* 206 */         arrayList1.add(str);
/*     */         
/* 208 */         j += (str.length() + 1) * CHAR_TO_BYTES;
/*     */       } 
/*     */     } 
/*     */     
/* 212 */     if (memory2 != null) {
/* 213 */       int j = 0;
/* 214 */       while (j < memory2.size()) {
/* 215 */         String str = null;
/* 216 */         if (CHAR_TO_BYTES == 1) {
/* 217 */           str = memory2.getString(j);
/*     */         } else {
/* 219 */           str = memory2.getWideString(j);
/*     */         } 
/*     */         
/* 222 */         if (str.isEmpty()) {
/*     */           break;
/*     */         }
/* 225 */         arrayList2.add(str);
/*     */         
/* 227 */         j += (str.length() + 1) * CHAR_TO_BYTES;
/*     */       } 
/*     */     } 
/*     */     
/* 231 */     return new PdhEnumObjectItems(arrayList1, arrayList2);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static class PdhEnumObjectItems
/*     */   {
/*     */     private final List<String> counters;
/*     */ 
/*     */     
/*     */     private final List<String> instances;
/*     */ 
/*     */     
/*     */     public PdhEnumObjectItems(List<String> param1List1, List<String> param1List2) {
/* 245 */       this.counters = copyAndEmptyListForNullList(param1List1);
/* 246 */       this.instances = copyAndEmptyListForNullList(param1List2);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public List<String> getCounters() {
/* 254 */       return this.counters;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public List<String> getInstances() {
/* 262 */       return this.instances;
/*     */     }
/*     */     
/*     */     private List<String> copyAndEmptyListForNullList(List<String> param1List) {
/* 266 */       if (param1List == null) {
/* 267 */         return new ArrayList<String>();
/*     */       }
/* 269 */       return new ArrayList<String>(param1List);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public String toString() {
/* 275 */       return "PdhEnumObjectItems{counters=" + this.counters + ", instances=" + this.instances + '}';
/*     */     }
/*     */   }
/*     */   
/*     */   public static final class PdhException extends RuntimeException {
/*     */     private final int errorCode;
/*     */     
/*     */     public PdhException(int param1Int) {
/* 283 */       super(String.format("Pdh call failed with error code 0x%08X", new Object[] { Integer.valueOf(param1Int) }));
/* 284 */       this.errorCode = param1Int;
/*     */     }
/*     */     
/*     */     public int getErrorCode() {
/* 288 */       return this.errorCode;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\sun\jna\platform\win32\PdhUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */