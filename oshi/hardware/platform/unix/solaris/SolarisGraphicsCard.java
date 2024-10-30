/*     */ package oshi.hardware.platform.unix.solaris;
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
/*     */ final class SolarisGraphicsCard
/*     */   extends AbstractGraphicsCard
/*     */ {
/*     */   private static final String PCI_CLASS_DISPLAY = "0003";
/*     */   
/*     */   SolarisGraphicsCard(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong) {
/*  59 */     super(paramString1, paramString2, paramString3, paramString4, paramLong);
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
/*     */   public static List<GraphicsCard> getGraphicsCards() {
/*  72 */     ArrayList<GraphicsCard> arrayList = new ArrayList();
/*     */     
/*  74 */     List list = ExecutingCommand.runNative("prtconf -pv");
/*  75 */     if (list.isEmpty()) {
/*  76 */       return arrayList;
/*     */     }
/*  78 */     String str1 = "";
/*  79 */     String str2 = "";
/*  80 */     String str3 = "";
/*  81 */     String str4 = "";
/*  82 */     ArrayList<? extends CharSequence> arrayList1 = new ArrayList();
/*  83 */     for (String str : list) {
/*     */ 
/*     */       
/*  86 */       if (str.contains("Node 0x")) {
/*  87 */         if ("0003".equals(str4)) {
/*  88 */           arrayList.add(new SolarisGraphicsCard(str1.isEmpty() ? "unknown" : str1, 
/*  89 */                 str3.isEmpty() ? "unknown" : str3, 
/*  90 */                 str2.isEmpty() ? "unknown" : str2, 
/*  91 */                 arrayList1.isEmpty() ? "unknown" : String.join(", ", arrayList1), 0L));
/*     */         }
/*     */         
/*  94 */         str1 = "";
/*  95 */         str2 = "unknown";
/*  96 */         str3 = "unknown";
/*  97 */         str4 = "";
/*  98 */         arrayList1.clear(); continue;
/*     */       } 
/* 100 */       String[] arrayOfString = str.trim().split(":", 2);
/* 101 */       if (arrayOfString.length == 2) {
/* 102 */         if (arrayOfString[0].equals("model")) {
/*     */           
/* 104 */           str1 = ParseUtil.getSingleQuoteStringValue(str); continue;
/* 105 */         }  if (arrayOfString[0].equals("name")) {
/*     */ 
/*     */           
/* 108 */           if (str1.isEmpty())
/* 109 */             str1 = ParseUtil.getSingleQuoteStringValue(str);  continue;
/*     */         } 
/* 111 */         if (arrayOfString[0].equals("vendor-id")) {
/*     */           
/* 113 */           str2 = "0x" + str.substring(str.length() - 4); continue;
/* 114 */         }  if (arrayOfString[0].equals("device-id")) {
/*     */           
/* 116 */           str3 = "0x" + str.substring(str.length() - 4); continue;
/* 117 */         }  if (arrayOfString[0].equals("revision-id")) {
/*     */           
/* 119 */           arrayList1.add(str.trim()); continue;
/* 120 */         }  if (arrayOfString[0].equals("class-code"))
/*     */         {
/*     */           
/* 123 */           str4 = str.substring(str.length() - 8, str.length() - 4);
/*     */         }
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 129 */     if ("0003".equals(str4)) {
/* 130 */       arrayList.add(new SolarisGraphicsCard(str1.isEmpty() ? "unknown" : str1, 
/* 131 */             str3.isEmpty() ? "unknown" : str3, 
/* 132 */             str2.isEmpty() ? "unknown" : str2, 
/* 133 */             arrayList1.isEmpty() ? "unknown" : String.join(", ", arrayList1), 0L));
/*     */     }
/* 135 */     return arrayList;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\hardware\platfor\\unix\solaris\SolarisGraphicsCard.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */