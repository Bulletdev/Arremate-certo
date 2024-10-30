/*     */ package oshi.driver.windows;
/*     */ 
/*     */ import com.sun.jna.Memory;
/*     */ import com.sun.jna.Pointer;
/*     */ import com.sun.jna.platform.win32.Cfgmgr32;
/*     */ import com.sun.jna.platform.win32.Cfgmgr32Util;
/*     */ import com.sun.jna.platform.win32.Guid;
/*     */ import com.sun.jna.platform.win32.SetupApi;
/*     */ import com.sun.jna.platform.win32.WinBase;
/*     */ import com.sun.jna.platform.win32.WinNT;
/*     */ import com.sun.jna.ptr.IntByReference;
/*     */ import java.util.ArrayDeque;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import java.util.stream.Collectors;
/*     */ import oshi.annotation.concurrent.ThreadSafe;
/*     */ import oshi.util.tuples.Quintet;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @ThreadSafe
/*     */ public final class DeviceTree
/*     */ {
/*     */   private static final int MAX_PATH = 260;
/*  62 */   private static final SetupApi SA = SetupApi.INSTANCE;
/*  63 */   private static final Cfgmgr32 C32 = Cfgmgr32.INSTANCE;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Quintet<Set<Integer>, Map<Integer, Integer>, Map<Integer, String>, Map<Integer, String>, Map<Integer, String>> queryDeviceTree(Guid.GUID paramGUID) {
/*  88 */     HashMap<Object, Object> hashMap1 = new HashMap<>();
/*  89 */     HashMap<Object, Object> hashMap2 = new HashMap<>();
/*  90 */     HashMap<Object, Object> hashMap3 = new HashMap<>();
/*  91 */     HashMap<Object, Object> hashMap4 = new HashMap<>();
/*     */     
/*  93 */     WinNT.HANDLE hANDLE = SA.SetupDiGetClassDevs(paramGUID, null, null, 18);
/*  94 */     if (hANDLE != WinBase.INVALID_HANDLE_VALUE) {
/*     */       
/*     */       try {
/*  97 */         Memory memory = new Memory(260L);
/*  98 */         IntByReference intByReference = new IntByReference(260);
/*     */         
/* 100 */         ArrayDeque<Integer> arrayDeque = new ArrayDeque();
/*     */         
/* 102 */         SetupApi.SP_DEVINFO_DATA sP_DEVINFO_DATA = new SetupApi.SP_DEVINFO_DATA();
/* 103 */         sP_DEVINFO_DATA.cbSize = sP_DEVINFO_DATA.size();
/* 104 */         for (byte b = 0; SA.SetupDiEnumDeviceInfo(hANDLE, b, sP_DEVINFO_DATA); b++) {
/* 105 */           arrayDeque.add(Integer.valueOf(sP_DEVINFO_DATA.DevInst));
/*     */           
/* 107 */           int i = 0;
/* 108 */           IntByReference intByReference1 = new IntByReference();
/* 109 */           IntByReference intByReference2 = new IntByReference();
/* 110 */           while (!arrayDeque.isEmpty()) {
/*     */             
/* 112 */             i = ((Integer)arrayDeque.poll()).intValue();
/*     */ 
/*     */             
/* 115 */             String str1 = Cfgmgr32Util.CM_Get_Device_ID(i);
/* 116 */             hashMap3.put(Integer.valueOf(i), str1);
/*     */ 
/*     */             
/* 119 */             String str2 = getDevNodeProperty(i, 13, memory, intByReference);
/* 120 */             if (str2.isEmpty()) {
/* 121 */               str2 = getDevNodeProperty(i, 1, memory, intByReference);
/*     */             }
/* 123 */             if (str2.isEmpty()) {
/* 124 */               str2 = getDevNodeProperty(i, 8, memory, intByReference);
/* 125 */               String str = getDevNodeProperty(i, 5, memory, intByReference);
/* 126 */               if (!str.isEmpty()) {
/* 127 */                 str2 = str2 + " (" + str + ")";
/*     */               }
/*     */             } 
/* 130 */             hashMap2.put(Integer.valueOf(i), str2);
/* 131 */             hashMap4.put(Integer.valueOf(i), getDevNodeProperty(i, 12, memory, intByReference));
/*     */ 
/*     */             
/* 134 */             if (0 == C32.CM_Get_Child(intByReference1, i, 0)) {
/* 135 */               hashMap1.put(Integer.valueOf(intByReference1.getValue()), Integer.valueOf(i));
/* 136 */               arrayDeque.add(Integer.valueOf(intByReference1.getValue()));
/* 137 */               while (0 == C32.CM_Get_Sibling(intByReference2, intByReference1.getValue(), 0)) {
/* 138 */                 hashMap1.put(Integer.valueOf(intByReference2.getValue()), Integer.valueOf(i));
/* 139 */                 arrayDeque.add(Integer.valueOf(intByReference2.getValue()));
/* 140 */                 intByReference1.setValue(intByReference2.getValue());
/*     */               } 
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       } finally {
/* 146 */         SA.SetupDiDestroyDeviceInfoList(hANDLE);
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/* 151 */     Set set = (Set)hashMap3.keySet().stream().filter(paramInteger -> !paramMap.containsKey(paramInteger)).collect(Collectors.toSet());
/* 152 */     return new Quintet(set, hashMap1, hashMap2, hashMap3, hashMap4);
/*     */   }
/*     */   
/*     */   private static String getDevNodeProperty(int paramInt1, int paramInt2, Memory paramMemory, IntByReference paramIntByReference) {
/* 156 */     paramMemory.clear();
/* 157 */     paramIntByReference.setValue((int)paramMemory.size());
/* 158 */     C32.CM_Get_DevNode_Registry_Property(paramInt1, paramInt2, null, (Pointer)paramMemory, paramIntByReference, 0);
/* 159 */     return paramMemory.getWideString(0L);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\driver\windows\DeviceTree.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */