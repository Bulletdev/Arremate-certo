/*     */ package oshi.hardware.common;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import oshi.annotation.concurrent.ThreadSafe;
/*     */ import oshi.hardware.GlobalMemory;
/*     */ import oshi.hardware.PhysicalMemory;
/*     */ import oshi.util.ExecutingCommand;
/*     */ import oshi.util.FormatUtil;
/*     */ import oshi.util.ParseUtil;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */ public abstract class AbstractGlobalMemory
/*     */   implements GlobalMemory
/*     */ {
/*     */   public List<PhysicalMemory> getPhysicalMemory() {
/*  47 */     ArrayList<PhysicalMemory> arrayList = new ArrayList();
/*  48 */     List list = ExecutingCommand.runNative("dmidecode --type 17");
/*  49 */     byte b = 0;
/*  50 */     String str1 = "unknown";
/*  51 */     String str2 = "";
/*  52 */     long l1 = 0L;
/*  53 */     long l2 = 0L;
/*  54 */     String str3 = "unknown";
/*  55 */     String str4 = "unknown";
/*  56 */     for (String str : list) {
/*  57 */       if (str.trim().contains("DMI type 17")) {
/*     */         
/*  59 */         if (b++ > 0) {
/*  60 */           if (l1 > 0L) {
/*  61 */             arrayList.add(new PhysicalMemory(str1 + str2, l1, l2, str3, str4));
/*     */           }
/*  63 */           str1 = "unknown";
/*  64 */           str2 = "";
/*  65 */           l1 = 0L;
/*  66 */           l2 = 0L;
/*     */         }  continue;
/*  68 */       }  if (b > 0) {
/*  69 */         String[] arrayOfString = str.trim().split(":");
/*  70 */         if (arrayOfString.length == 2) {
/*  71 */           switch (arrayOfString[0]) {
/*     */             case "Bank Locator":
/*  73 */               str1 = arrayOfString[1].trim();
/*     */             
/*     */             case "Locator":
/*  76 */               str2 = "/" + arrayOfString[1].trim();
/*     */             
/*     */             case "Size":
/*  79 */               l1 = ParseUtil.parseDecimalMemorySizeToBinary(arrayOfString[1].trim());
/*     */             
/*     */             case "Type":
/*  82 */               str4 = arrayOfString[1].trim();
/*     */             
/*     */             case "Speed":
/*  85 */               l2 = ParseUtil.parseHertz(arrayOfString[1]);
/*     */             
/*     */             case "Manufacturer":
/*  88 */               str3 = arrayOfString[1].trim();
/*     */           } 
/*     */ 
/*     */ 
/*     */         
/*     */         }
/*     */       } 
/*     */     } 
/*  96 */     if (l1 > 0L) {
/*  97 */       arrayList.add(new PhysicalMemory(str1 + str2, l1, l2, str3, str4));
/*     */     }
/*  99 */     return arrayList;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 104 */     StringBuilder stringBuilder = new StringBuilder();
/* 105 */     stringBuilder.append("Available: ");
/* 106 */     stringBuilder.append(FormatUtil.formatBytes(getAvailable()));
/* 107 */     stringBuilder.append("/");
/* 108 */     stringBuilder.append(FormatUtil.formatBytes(getTotal()));
/* 109 */     return stringBuilder.toString();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\hardware\common\AbstractGlobalMemory.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */