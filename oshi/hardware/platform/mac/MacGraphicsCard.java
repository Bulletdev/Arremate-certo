/*     */ package oshi.hardware.platform.mac;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import oshi.annotation.concurrent.Immutable;
/*     */ import oshi.hardware.GraphicsCard;
/*     */ import oshi.hardware.common.AbstractGraphicsCard;
/*     */ import oshi.util.ExecutingCommand;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Immutable
/*     */ final class MacGraphicsCard
/*     */   extends AbstractGraphicsCard
/*     */ {
/*     */   MacGraphicsCard(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong) {
/*  57 */     super(paramString1, paramString2, paramString3, paramString4, paramLong);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static List<GraphicsCard> getGraphicsCards() {
/*  68 */     ArrayList<MacGraphicsCard> arrayList = new ArrayList();
/*  69 */     List list = ExecutingCommand.runNative("system_profiler SPDisplaysDataType");
/*  70 */     String str1 = "unknown";
/*  71 */     String str2 = "unknown";
/*  72 */     String str3 = "unknown";
/*  73 */     ArrayList<? extends CharSequence> arrayList1 = new ArrayList();
/*  74 */     long l = 0L;
/*  75 */     byte b = 0;
/*  76 */     for (String str : list) {
/*  77 */       String[] arrayOfString = str.trim().split(":", 2);
/*  78 */       if (arrayOfString.length == 2) {
/*  79 */         String str4 = arrayOfString[0].toLowerCase();
/*  80 */         if (str4.equals("chipset model")) {
/*     */           
/*  82 */           if (b++ > 0) {
/*  83 */             arrayList.add(new MacGraphicsCard(str1, str2, str3, 
/*  84 */                   arrayList1.isEmpty() ? "unknown" : String.join(", ", arrayList1), l));
/*     */             
/*  86 */             arrayList1.clear();
/*     */           } 
/*  88 */           str1 = arrayOfString[1].trim(); continue;
/*  89 */         }  if (str4.equals("device id")) {
/*  90 */           str2 = arrayOfString[1].trim(); continue;
/*  91 */         }  if (str4.equals("vendor")) {
/*  92 */           str3 = arrayOfString[1].trim(); continue;
/*  93 */         }  if (str4.contains("version") || str4.contains("revision")) {
/*  94 */           arrayList1.add(str.trim()); continue;
/*  95 */         }  if (str4.startsWith("vram")) {
/*  96 */           l = ParseUtil.parseDecimalMemorySizeToBinary(arrayOfString[1].trim());
/*     */         }
/*     */       } 
/*     */     } 
/* 100 */     arrayList.add(new MacGraphicsCard(str1, str2, str3, 
/* 101 */           arrayList1.isEmpty() ? "unknown" : String.join(", ", arrayList1), l));
/* 102 */     return (List)arrayList;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\hardware\platform\mac\MacGraphicsCard.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */