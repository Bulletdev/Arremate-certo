/*     */ package org.apache.http.conn.routing;
/*     */ 
/*     */ import org.apache.http.annotation.Contract;
/*     */ import org.apache.http.annotation.ThreadingBehavior;
/*     */ import org.apache.http.util.Args;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Contract(threading = ThreadingBehavior.IMMUTABLE)
/*     */ public class BasicRouteDirector
/*     */   implements HttpRouteDirector
/*     */ {
/*     */   public int nextStep(RouteInfo paramRouteInfo1, RouteInfo paramRouteInfo2) {
/*  55 */     Args.notNull(paramRouteInfo1, "Planned route");
/*     */     
/*  57 */     int i = -1;
/*     */     
/*  59 */     if (paramRouteInfo2 == null || paramRouteInfo2.getHopCount() < 1) {
/*  60 */       i = firstStep(paramRouteInfo1);
/*  61 */     } else if (paramRouteInfo1.getHopCount() > 1) {
/*  62 */       i = proxiedStep(paramRouteInfo1, paramRouteInfo2);
/*     */     } else {
/*  64 */       i = directStep(paramRouteInfo1, paramRouteInfo2);
/*     */     } 
/*     */     
/*  67 */     return i;
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
/*     */   protected int firstStep(RouteInfo paramRouteInfo) {
/*  81 */     return (paramRouteInfo.getHopCount() > 1) ? 2 : 1;
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
/*     */   protected int directStep(RouteInfo paramRouteInfo1, RouteInfo paramRouteInfo2) {
/*  97 */     if (paramRouteInfo2.getHopCount() > 1) {
/*  98 */       return -1;
/*     */     }
/* 100 */     if (!paramRouteInfo1.getTargetHost().equals(paramRouteInfo2.getTargetHost()))
/*     */     {
/* 102 */       return -1;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 111 */     if (paramRouteInfo1.isSecure() != paramRouteInfo2.isSecure()) {
/* 112 */       return -1;
/*     */     }
/*     */ 
/*     */     
/* 116 */     if (paramRouteInfo1.getLocalAddress() != null && !paramRouteInfo1.getLocalAddress().equals(paramRouteInfo2.getLocalAddress()))
/*     */     {
/*     */       
/* 119 */       return -1;
/*     */     }
/*     */     
/* 122 */     return 0;
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
/*     */   protected int proxiedStep(RouteInfo paramRouteInfo1, RouteInfo paramRouteInfo2) {
/* 137 */     if (paramRouteInfo2.getHopCount() <= 1) {
/* 138 */       return -1;
/*     */     }
/* 140 */     if (!paramRouteInfo1.getTargetHost().equals(paramRouteInfo2.getTargetHost())) {
/* 141 */       return -1;
/*     */     }
/* 143 */     int i = paramRouteInfo1.getHopCount();
/* 144 */     int j = paramRouteInfo2.getHopCount();
/* 145 */     if (i < j) {
/* 146 */       return -1;
/*     */     }
/*     */     
/* 149 */     for (byte b = 0; b < j - 1; b++) {
/* 150 */       if (!paramRouteInfo1.getHopTarget(b).equals(paramRouteInfo2.getHopTarget(b))) {
/* 151 */         return -1;
/*     */       }
/*     */     } 
/*     */     
/* 155 */     if (i > j)
/*     */     {
/* 157 */       return 4;
/*     */     }
/*     */ 
/*     */     
/* 161 */     if ((paramRouteInfo2.isTunnelled() && !paramRouteInfo1.isTunnelled()) || (paramRouteInfo2.isLayered() && !paramRouteInfo1.isLayered()))
/*     */     {
/* 163 */       return -1;
/*     */     }
/*     */     
/* 166 */     if (paramRouteInfo1.isTunnelled() && !paramRouteInfo2.isTunnelled()) {
/* 167 */       return 3;
/*     */     }
/* 169 */     if (paramRouteInfo1.isLayered() && !paramRouteInfo2.isLayered()) {
/* 170 */       return 5;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 176 */     if (paramRouteInfo1.isSecure() != paramRouteInfo2.isSecure()) {
/* 177 */       return -1;
/*     */     }
/*     */     
/* 180 */     return 0;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\conn\routing\BasicRouteDirector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */