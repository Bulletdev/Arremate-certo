/*     */ package oshi.hardware.platform.unix.freebsd;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
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
/*     */ final class FreeBsdGraphicsCard
/*     */   extends AbstractGraphicsCard
/*     */ {
/*     */   private static final String PCI_CLASS_DISPLAY = "0x03";
/*     */   
/*     */   FreeBsdGraphicsCard(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong) {
/*  60 */     super(paramString1, paramString2, paramString3, paramString4, paramLong);
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
/*  73 */     ArrayList<FreeBsdGraphicsCard> arrayList = new ArrayList();
/*     */     
/*  75 */     List list = ExecutingCommand.runNative("pciconf -lv");
/*  76 */     if (list.isEmpty()) {
/*  77 */       return Collections.emptyList();
/*     */     }
/*  79 */     String str1 = "unknown";
/*  80 */     String str2 = "unknown";
/*  81 */     String str3 = "unknown";
/*  82 */     String str4 = "";
/*  83 */     String str5 = "unknown";
/*  84 */     for (String str : list) {
/*  85 */       if (str.contains("class=0x")) {
/*     */         
/*  87 */         if ("0x03".equals(str4)) {
/*  88 */           arrayList.add(new FreeBsdGraphicsCard(str1.isEmpty() ? "unknown" : str1, 
/*  89 */                 str3.isEmpty() ? "unknown" : str3, 
/*  90 */                 str2.isEmpty() ? "unknown" : str2, 
/*  91 */                 str5.isEmpty() ? "unknown" : str5, 0L));
/*     */         }
/*     */         
/*  94 */         String[] arrayOfString1 = ParseUtil.whitespaces.split(str);
/*  95 */         for (String str6 : arrayOfString1) {
/*  96 */           String[] arrayOfString2 = str6.split("=");
/*  97 */           if (arrayOfString2.length > 1) {
/*  98 */             if (arrayOfString2[0].equals("class") && arrayOfString2[1].length() >= 4) {
/*     */               
/* 100 */               str4 = arrayOfString2[1].substring(0, 4);
/* 101 */             } else if (arrayOfString2[0].equals("chip") && arrayOfString2[1].length() >= 10) {
/*     */               
/* 103 */               str3 = arrayOfString2[1].substring(0, 6);
/* 104 */               str2 = "0x" + arrayOfString2[1].substring(6, 10);
/* 105 */             } else if (arrayOfString2[0].contains("rev")) {
/*     */               
/* 107 */               str5 = str6;
/*     */             } 
/*     */           }
/*     */         } 
/*     */         
/* 112 */         str1 = "unknown"; continue;
/*     */       } 
/* 114 */       String[] arrayOfString = str.trim().split("=", 2);
/* 115 */       if (arrayOfString.length == 2) {
/* 116 */         String str6 = arrayOfString[0].trim();
/* 117 */         if (str6.equals("vendor")) {
/*     */           
/* 119 */           str2 = ParseUtil.getSingleQuoteStringValue(str) + (str2.equals("unknown") ? "" : (" (" + str2 + ")")); continue;
/* 120 */         }  if (str6.equals("device")) {
/* 121 */           str1 = ParseUtil.getSingleQuoteStringValue(str);
/*     */         }
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 127 */     if ("0x03".equals(str4)) {
/* 128 */       arrayList.add(new FreeBsdGraphicsCard(str1.isEmpty() ? "unknown" : str1, 
/* 129 */             str3.isEmpty() ? "unknown" : str3, 
/* 130 */             str2.isEmpty() ? "unknown" : str2, 
/* 131 */             str5.isEmpty() ? "unknown" : str5, 0L));
/*     */     }
/* 133 */     return (List)arrayList;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\hardware\platfor\\unix\freebsd\FreeBsdGraphicsCard.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */