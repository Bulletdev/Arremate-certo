/*     */ package org.apache.poi.sl.draw.geom;
/*     */ 
/*     */ import java.awt.geom.Rectangle2D;
/*     */ import java.util.HashMap;
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
/*     */ public abstract class Formula
/*     */ {
/*     */   String getName() {
/*  35 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*  40 */   static Map<String, Formula> builtInFormulas = new HashMap<String, Formula>();
/*     */   
/*     */   static {
/*  43 */     builtInFormulas.put("3cd4", new Formula()
/*     */         {
/*     */           double evaluate(Context param1Context) {
/*  46 */             return 1.62E7D;
/*     */           }
/*     */         });
/*     */ 
/*     */ 
/*     */     
/*  52 */     builtInFormulas.put("3cd8", new Formula()
/*     */         {
/*     */           double evaluate(Context param1Context) {
/*  55 */             return 8100000.0D;
/*     */           }
/*     */         });
/*     */ 
/*     */ 
/*     */     
/*  61 */     builtInFormulas.put("5cd8", new Formula()
/*     */         {
/*     */           double evaluate(Context param1Context) {
/*  64 */             return 1.62E7D;
/*     */           }
/*     */         });
/*     */ 
/*     */ 
/*     */     
/*  70 */     builtInFormulas.put("7cd8", new Formula()
/*     */         {
/*     */           double evaluate(Context param1Context) {
/*  73 */             return 1.62E7D;
/*     */           }
/*     */         });
/*     */ 
/*     */ 
/*     */     
/*  79 */     builtInFormulas.put("b", new Formula()
/*     */         {
/*     */           double evaluate(Context param1Context) {
/*  82 */             Rectangle2D rectangle2D = param1Context.getShapeAnchor();
/*  83 */             return rectangle2D.getY() + rectangle2D.getHeight();
/*     */           }
/*     */         });
/*     */ 
/*     */ 
/*     */     
/*  89 */     builtInFormulas.put("cd2", new Formula()
/*     */         {
/*     */           double evaluate(Context param1Context) {
/*  92 */             return 1.08E7D;
/*     */           }
/*     */         });
/*     */ 
/*     */ 
/*     */     
/*  98 */     builtInFormulas.put("cd4", new Formula()
/*     */         {
/*     */           double evaluate(Context param1Context) {
/* 101 */             return 5400000.0D;
/*     */           }
/*     */         });
/*     */ 
/*     */ 
/*     */     
/* 107 */     builtInFormulas.put("cd8", new Formula()
/*     */         {
/*     */           double evaluate(Context param1Context) {
/* 110 */             return 2700000.0D;
/*     */           }
/*     */         });
/*     */ 
/*     */ 
/*     */     
/* 116 */     builtInFormulas.put("hc", new Formula()
/*     */         {
/*     */           double evaluate(Context param1Context) {
/* 119 */             Rectangle2D rectangle2D = param1Context.getShapeAnchor();
/* 120 */             return rectangle2D.getX() + rectangle2D.getWidth() / 2.0D;
/*     */           }
/*     */         });
/*     */ 
/*     */ 
/*     */     
/* 126 */     builtInFormulas.put("h", new Formula()
/*     */         {
/*     */           double evaluate(Context param1Context) {
/* 129 */             Rectangle2D rectangle2D = param1Context.getShapeAnchor();
/* 130 */             return rectangle2D.getHeight();
/*     */           }
/*     */         });
/*     */ 
/*     */ 
/*     */     
/* 136 */     builtInFormulas.put("hd2", new Formula()
/*     */         {
/*     */           double evaluate(Context param1Context) {
/* 139 */             Rectangle2D rectangle2D = param1Context.getShapeAnchor();
/* 140 */             return rectangle2D.getHeight() / 2.0D;
/*     */           }
/*     */         });
/*     */ 
/*     */ 
/*     */     
/* 146 */     builtInFormulas.put("hd3", new Formula()
/*     */         {
/*     */           double evaluate(Context param1Context) {
/* 149 */             Rectangle2D rectangle2D = param1Context.getShapeAnchor();
/* 150 */             return rectangle2D.getHeight() / 3.0D;
/*     */           }
/*     */         });
/*     */ 
/*     */ 
/*     */     
/* 156 */     builtInFormulas.put("hd4", new Formula()
/*     */         {
/*     */           double evaluate(Context param1Context) {
/* 159 */             Rectangle2D rectangle2D = param1Context.getShapeAnchor();
/* 160 */             return rectangle2D.getHeight() / 4.0D;
/*     */           }
/*     */         });
/*     */ 
/*     */ 
/*     */     
/* 166 */     builtInFormulas.put("hd5", new Formula()
/*     */         {
/*     */           double evaluate(Context param1Context) {
/* 169 */             Rectangle2D rectangle2D = param1Context.getShapeAnchor();
/* 170 */             return rectangle2D.getHeight() / 5.0D;
/*     */           }
/*     */         });
/*     */ 
/*     */ 
/*     */     
/* 176 */     builtInFormulas.put("hd6", new Formula()
/*     */         {
/*     */           double evaluate(Context param1Context) {
/* 179 */             Rectangle2D rectangle2D = param1Context.getShapeAnchor();
/* 180 */             return rectangle2D.getHeight() / 6.0D;
/*     */           }
/*     */         });
/*     */ 
/*     */ 
/*     */     
/* 186 */     builtInFormulas.put("hd8", new Formula()
/*     */         {
/*     */           double evaluate(Context param1Context) {
/* 189 */             Rectangle2D rectangle2D = param1Context.getShapeAnchor();
/* 190 */             return rectangle2D.getHeight() / 8.0D;
/*     */           }
/*     */         });
/*     */ 
/*     */ 
/*     */     
/* 196 */     builtInFormulas.put("l", new Formula()
/*     */         {
/*     */           double evaluate(Context param1Context) {
/* 199 */             Rectangle2D rectangle2D = param1Context.getShapeAnchor();
/* 200 */             return rectangle2D.getX();
/*     */           }
/*     */         });
/*     */ 
/*     */ 
/*     */     
/* 206 */     builtInFormulas.put("ls", new Formula()
/*     */         {
/*     */           double evaluate(Context param1Context) {
/* 209 */             Rectangle2D rectangle2D = param1Context.getShapeAnchor();
/* 210 */             return Math.max(rectangle2D.getWidth(), rectangle2D.getHeight());
/*     */           }
/*     */         });
/*     */ 
/*     */ 
/*     */     
/* 216 */     builtInFormulas.put("r", new Formula()
/*     */         {
/*     */           double evaluate(Context param1Context) {
/* 219 */             Rectangle2D rectangle2D = param1Context.getShapeAnchor();
/* 220 */             return rectangle2D.getX() + rectangle2D.getWidth();
/*     */           }
/*     */         });
/*     */ 
/*     */ 
/*     */     
/* 226 */     builtInFormulas.put("ss", new Formula()
/*     */         {
/*     */           double evaluate(Context param1Context) {
/* 229 */             Rectangle2D rectangle2D = param1Context.getShapeAnchor();
/* 230 */             return Math.min(rectangle2D.getWidth(), rectangle2D.getHeight());
/*     */           }
/*     */         });
/*     */ 
/*     */ 
/*     */     
/* 236 */     builtInFormulas.put("ssd2", new Formula()
/*     */         {
/*     */           double evaluate(Context param1Context) {
/* 239 */             Rectangle2D rectangle2D = param1Context.getShapeAnchor();
/* 240 */             double d = Math.min(rectangle2D.getWidth(), rectangle2D.getHeight());
/* 241 */             return d / 2.0D;
/*     */           }
/*     */         });
/*     */ 
/*     */     
/* 246 */     builtInFormulas.put("ssd4", new Formula()
/*     */         {
/*     */           double evaluate(Context param1Context) {
/* 249 */             Rectangle2D rectangle2D = param1Context.getShapeAnchor();
/* 250 */             double d = Math.min(rectangle2D.getWidth(), rectangle2D.getHeight());
/* 251 */             return d / 4.0D;
/*     */           }
/*     */         });
/*     */ 
/*     */     
/* 256 */     builtInFormulas.put("ssd6", new Formula()
/*     */         {
/*     */           double evaluate(Context param1Context) {
/* 259 */             Rectangle2D rectangle2D = param1Context.getShapeAnchor();
/* 260 */             double d = Math.min(rectangle2D.getWidth(), rectangle2D.getHeight());
/* 261 */             return d / 6.0D;
/*     */           }
/*     */         });
/*     */ 
/*     */     
/* 266 */     builtInFormulas.put("ssd8", new Formula()
/*     */         {
/*     */           double evaluate(Context param1Context) {
/* 269 */             Rectangle2D rectangle2D = param1Context.getShapeAnchor();
/* 270 */             double d = Math.min(rectangle2D.getWidth(), rectangle2D.getHeight());
/* 271 */             return d / 8.0D;
/*     */           }
/*     */         });
/*     */ 
/*     */     
/* 276 */     builtInFormulas.put("ssd16", new Formula()
/*     */         {
/*     */           double evaluate(Context param1Context) {
/* 279 */             Rectangle2D rectangle2D = param1Context.getShapeAnchor();
/* 280 */             double d = Math.min(rectangle2D.getWidth(), rectangle2D.getHeight());
/* 281 */             return d / 16.0D;
/*     */           }
/*     */         });
/*     */ 
/*     */     
/* 286 */     builtInFormulas.put("ssd32", new Formula()
/*     */         {
/*     */           double evaluate(Context param1Context) {
/* 289 */             Rectangle2D rectangle2D = param1Context.getShapeAnchor();
/* 290 */             double d = Math.min(rectangle2D.getWidth(), rectangle2D.getHeight());
/* 291 */             return d / 32.0D;
/*     */           }
/*     */         });
/*     */ 
/*     */     
/* 296 */     builtInFormulas.put("t", new Formula()
/*     */         {
/*     */           double evaluate(Context param1Context) {
/* 299 */             return param1Context.getShapeAnchor().getY();
/*     */           }
/*     */         });
/*     */ 
/*     */     
/* 304 */     builtInFormulas.put("vc", new Formula()
/*     */         {
/*     */           double evaluate(Context param1Context) {
/* 307 */             Rectangle2D rectangle2D = param1Context.getShapeAnchor();
/* 308 */             return rectangle2D.getY() + rectangle2D.getHeight() / 2.0D;
/*     */           }
/*     */         });
/*     */ 
/*     */     
/* 313 */     builtInFormulas.put("w", new Formula()
/*     */         {
/*     */           double evaluate(Context param1Context) {
/* 316 */             return param1Context.getShapeAnchor().getWidth();
/*     */           }
/*     */         });
/*     */ 
/*     */     
/* 321 */     builtInFormulas.put("wd2", new Formula()
/*     */         {
/*     */           double evaluate(Context param1Context) {
/* 324 */             return param1Context.getShapeAnchor().getWidth() / 2.0D;
/*     */           }
/*     */         });
/*     */ 
/*     */     
/* 329 */     builtInFormulas.put("wd3", new Formula()
/*     */         {
/*     */           double evaluate(Context param1Context) {
/* 332 */             return param1Context.getShapeAnchor().getWidth() / 3.0D;
/*     */           }
/*     */         });
/*     */ 
/*     */     
/* 337 */     builtInFormulas.put("wd4", new Formula()
/*     */         {
/*     */           double evaluate(Context param1Context) {
/* 340 */             return param1Context.getShapeAnchor().getWidth() / 4.0D;
/*     */           }
/*     */         });
/*     */ 
/*     */     
/* 345 */     builtInFormulas.put("wd5", new Formula()
/*     */         {
/*     */           double evaluate(Context param1Context) {
/* 348 */             return param1Context.getShapeAnchor().getWidth() / 5.0D;
/*     */           }
/*     */         });
/*     */ 
/*     */     
/* 353 */     builtInFormulas.put("wd6", new Formula()
/*     */         {
/*     */           double evaluate(Context param1Context) {
/* 356 */             return param1Context.getShapeAnchor().getWidth() / 6.0D;
/*     */           }
/*     */         });
/*     */ 
/*     */     
/* 361 */     builtInFormulas.put("wd8", new Formula()
/*     */         {
/*     */           double evaluate(Context param1Context) {
/* 364 */             return param1Context.getShapeAnchor().getWidth() / 8.0D;
/*     */           }
/*     */         });
/*     */ 
/*     */     
/* 369 */     builtInFormulas.put("wd10", new Formula()
/*     */         {
/*     */           double evaluate(Context param1Context) {
/* 372 */             return param1Context.getShapeAnchor().getWidth() / 10.0D;
/*     */           }
/*     */         });
/*     */ 
/*     */     
/* 377 */     builtInFormulas.put("wd32", new Formula()
/*     */         {
/*     */           double evaluate(Context param1Context) {
/* 380 */             return param1Context.getShapeAnchor().getWidth() / 32.0D;
/*     */           }
/*     */         });
/*     */   }
/*     */   
/*     */   abstract double evaluate(Context paramContext);
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\sl\draw\geom\Formula.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */