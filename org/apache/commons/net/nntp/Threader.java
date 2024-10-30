/*     */ package org.apache.commons.net.nntp;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Threader
/*     */ {
/*     */   public Threadable thread(List<? extends Threadable> paramList) {
/*  45 */     return thread(paramList);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Threadable thread(Iterable<? extends Threadable> paramIterable) {
/*  56 */     if (paramIterable == null) {
/*  57 */       return null;
/*     */     }
/*     */     
/*  60 */     HashMap<Object, Object> hashMap = new HashMap<>();
/*     */ 
/*     */     
/*  63 */     for (Threadable threadable1 : paramIterable) {
/*  64 */       if (!threadable1.isDummy()) {
/*  65 */         buildContainer(threadable1, (HashMap)hashMap);
/*     */       }
/*     */     } 
/*     */     
/*  69 */     if (hashMap.isEmpty()) {
/*  70 */       return null;
/*     */     }
/*     */     
/*  73 */     ThreadContainer threadContainer1 = findRootSet((HashMap)hashMap);
/*  74 */     hashMap.clear();
/*  75 */     hashMap = null;
/*     */     
/*  77 */     pruneEmptyContainers(threadContainer1);
/*     */     
/*  79 */     threadContainer1.reverseChildren();
/*  80 */     gatherSubjects(threadContainer1);
/*     */     
/*  82 */     if (threadContainer1.next != null) {
/*  83 */       throw new RuntimeException("root node has a next:" + threadContainer1);
/*     */     }
/*     */     
/*  86 */     for (ThreadContainer threadContainer2 = threadContainer1.child; threadContainer2 != null; threadContainer2 = threadContainer2.next) {
/*  87 */       if (threadContainer2.threadable == null) {
/*  88 */         threadContainer2.threadable = threadContainer2.child.threadable.makeDummy();
/*     */       }
/*     */     } 
/*     */     
/*  92 */     Threadable threadable = (threadContainer1.child == null) ? null : threadContainer1.child.threadable;
/*  93 */     threadContainer1.flush();
/*     */     
/*  95 */     return threadable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void buildContainer(Threadable paramThreadable, HashMap<String, ThreadContainer> paramHashMap) {
/* 104 */     String str = paramThreadable.messageThreadId();
/* 105 */     ThreadContainer threadContainer1 = paramHashMap.get(str);
/* 106 */     byte b = 0;
/*     */ 
/*     */ 
/*     */     
/* 110 */     if (threadContainer1 != null) {
/* 111 */       if (threadContainer1.threadable != null) {
/* 112 */         b++;
/* 113 */         str = "<Bogus-id:" + b + ">";
/* 114 */         threadContainer1 = null;
/*     */       }
/*     */       else {
/*     */         
/* 118 */         threadContainer1.threadable = paramThreadable;
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/* 123 */     if (threadContainer1 == null) {
/* 124 */       threadContainer1 = new ThreadContainer();
/* 125 */       threadContainer1.threadable = paramThreadable;
/* 126 */       paramHashMap.put(str, threadContainer1);
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 131 */     ThreadContainer threadContainer2 = null;
/*     */     
/* 133 */     String[] arrayOfString = paramThreadable.messageThreadReferences();
/* 134 */     for (String str1 : arrayOfString) {
/*     */       
/* 136 */       ThreadContainer threadContainer = paramHashMap.get(str1);
/*     */ 
/*     */       
/* 139 */       if (threadContainer == null) {
/* 140 */         threadContainer = new ThreadContainer();
/* 141 */         paramHashMap.put(str1, threadContainer);
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 147 */       if (threadContainer2 != null && threadContainer.parent == null && threadContainer2 != threadContainer && 
/*     */ 
/*     */         
/* 150 */         !threadContainer.findChild(threadContainer2)) {
/*     */         
/* 152 */         threadContainer.parent = threadContainer2;
/* 153 */         threadContainer.next = threadContainer2.child;
/* 154 */         threadContainer2.child = threadContainer;
/*     */       } 
/* 156 */       threadContainer2 = threadContainer;
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 162 */     if (threadContainer2 != null && (threadContainer2 == threadContainer1 || threadContainer1
/* 163 */       .findChild(threadContainer2)))
/*     */     {
/* 165 */       threadContainer2 = null;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 171 */     if (threadContainer1.parent != null) {
/*     */ 
/*     */       
/* 174 */       ThreadContainer threadContainer4 = null, threadContainer3 = threadContainer1.parent.child;
/* 175 */       for (; threadContainer3 != null; 
/* 176 */         threadContainer4 = threadContainer3, threadContainer3 = threadContainer3.next) {
/* 177 */         if (threadContainer3 == threadContainer1) {
/*     */           break;
/*     */         }
/*     */       } 
/*     */       
/* 182 */       if (threadContainer3 == null) {
/* 183 */         throw new RuntimeException("Didnt find " + threadContainer1 + " in parent" + threadContainer1.parent);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 191 */       if (threadContainer4 == null) {
/* 192 */         threadContainer1.parent.child = threadContainer1.next;
/*     */       } else {
/* 194 */         threadContainer4.next = threadContainer1.next;
/*     */       } 
/*     */       
/* 197 */       threadContainer1.next = null;
/* 198 */       threadContainer1.parent = null;
/*     */     } 
/*     */ 
/*     */     
/* 202 */     if (threadContainer2 != null) {
/* 203 */       threadContainer1.parent = threadContainer2;
/* 204 */       threadContainer1.next = threadContainer2.child;
/* 205 */       threadContainer2.child = threadContainer1;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private ThreadContainer findRootSet(HashMap<String, ThreadContainer> paramHashMap) {
/* 215 */     ThreadContainer threadContainer = new ThreadContainer();
/* 216 */     Iterator<Map.Entry> iterator = paramHashMap.entrySet().iterator();
/*     */     
/* 218 */     while (iterator.hasNext()) {
/* 219 */       Map.Entry entry = iterator.next();
/* 220 */       ThreadContainer threadContainer1 = (ThreadContainer)entry.getValue();
/* 221 */       if (threadContainer1.parent == null) {
/* 222 */         if (threadContainer1.next != null) {
/* 223 */           throw new RuntimeException("c.next is " + threadContainer1.next
/* 224 */               .toString());
/*     */         }
/* 226 */         threadContainer1.next = threadContainer.child;
/* 227 */         threadContainer.child = threadContainer1;
/*     */       } 
/*     */     } 
/* 230 */     return threadContainer;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void pruneEmptyContainers(ThreadContainer paramThreadContainer) {
/* 239 */     ThreadContainer threadContainer2 = null, threadContainer1 = paramThreadContainer.child, threadContainer3 = threadContainer1.next;
/* 240 */     for (; threadContainer1 != null; 
/* 241 */       threadContainer2 = threadContainer1, 
/* 242 */       threadContainer1 = threadContainer3, 
/* 243 */       threadContainer3 = (threadContainer1 == null) ? null : threadContainer1.next) {
/*     */ 
/*     */       
/* 246 */       if (threadContainer1.threadable == null && threadContainer1.child == null) {
/* 247 */         if (threadContainer2 == null) {
/* 248 */           paramThreadContainer.child = threadContainer1.next;
/*     */         } else {
/* 250 */           threadContainer2.next = threadContainer1.next;
/*     */         } 
/*     */ 
/*     */         
/* 254 */         threadContainer1 = threadContainer2;
/*     */ 
/*     */       
/*     */       }
/* 258 */       else if (threadContainer1.threadable == null && threadContainer1.child != null && (threadContainer1.parent != null || threadContainer1.child.next == null)) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 265 */         ThreadContainer threadContainer5 = threadContainer1.child;
/*     */ 
/*     */         
/* 268 */         if (threadContainer2 == null) {
/* 269 */           paramThreadContainer.child = threadContainer5;
/*     */         } else {
/* 271 */           threadContainer2.next = threadContainer5;
/*     */         } 
/*     */ 
/*     */         
/*     */         ThreadContainer threadContainer4;
/*     */         
/* 277 */         for (threadContainer4 = threadContainer5; threadContainer4.next != null; threadContainer4 = threadContainer4.next) {
/* 278 */           threadContainer4.parent = threadContainer1.parent;
/*     */         }
/*     */         
/* 281 */         threadContainer4.parent = threadContainer1.parent;
/* 282 */         threadContainer4.next = threadContainer1.next;
/*     */ 
/*     */ 
/*     */         
/* 286 */         threadContainer3 = threadContainer5;
/*     */ 
/*     */         
/* 289 */         threadContainer1 = threadContainer2;
/* 290 */       } else if (threadContainer1.child != null) {
/*     */ 
/*     */         
/* 293 */         pruneEmptyContainers(threadContainer1);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void gatherSubjects(ThreadContainer paramThreadContainer) {
/* 305 */     byte b = 0;
/*     */     
/* 307 */     for (ThreadContainer threadContainer1 = paramThreadContainer.child; threadContainer1 != null; threadContainer1 = threadContainer1.next) {
/* 308 */       b++;
/*     */     }
/*     */ 
/*     */     
/* 312 */     HashMap<Object, Object> hashMap = new HashMap<>((int)(b * 1.2D), 0.9F);
/* 313 */     b = 0;
/*     */     ThreadContainer threadContainer2;
/* 315 */     for (threadContainer2 = paramThreadContainer.child; threadContainer2 != null; threadContainer2 = threadContainer2.next) {
/* 316 */       Threadable threadable = threadContainer2.threadable;
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 321 */       if (threadable == null) {
/* 322 */         threadable = threadContainer2.child.threadable;
/*     */       }
/*     */       
/* 325 */       String str = threadable.simplifiedSubject();
/*     */       
/* 327 */       if (str != null && !str.isEmpty()) {
/*     */ 
/*     */ 
/*     */         
/* 331 */         ThreadContainer threadContainer = (ThreadContainer)hashMap.get(str);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 340 */         if (threadContainer == null || (threadContainer2.threadable == null && threadContainer.threadable != null) || (threadContainer.threadable != null && threadContainer.threadable
/*     */ 
/*     */           
/* 343 */           .subjectIsReply() && threadContainer2.threadable != null && 
/*     */           
/* 345 */           !threadContainer2.threadable.subjectIsReply())) {
/* 346 */           hashMap.put(str, threadContainer2);
/* 347 */           b++;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 352 */     if (b == 0) {
/*     */       return;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 359 */     threadContainer2 = null; ThreadContainer threadContainer3 = paramThreadContainer.child, threadContainer4 = threadContainer3.next;
/* 360 */     for (; threadContainer3 != null; 
/* 361 */       threadContainer2 = threadContainer3, threadContainer3 = threadContainer4, threadContainer4 = (threadContainer4 == null) ? null : threadContainer4.next) {
/* 362 */       Threadable threadable = threadContainer3.threadable;
/*     */ 
/*     */       
/* 365 */       if (threadable == null) {
/* 366 */         threadable = threadContainer3.child.threadable;
/*     */       }
/*     */       
/* 369 */       String str = threadable.simplifiedSubject();
/*     */ 
/*     */       
/* 372 */       if (str != null && !str.isEmpty()) {
/*     */ 
/*     */ 
/*     */         
/* 376 */         ThreadContainer threadContainer = (ThreadContainer)hashMap.get(str);
/*     */         
/* 378 */         if (threadContainer != threadContainer3) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 384 */           if (threadContainer2 == null) {
/* 385 */             paramThreadContainer.child = threadContainer3.next;
/*     */           } else {
/* 387 */             threadContainer2.next = threadContainer3.next;
/*     */           } 
/* 389 */           threadContainer3.next = null;
/*     */           
/* 391 */           if (threadContainer.threadable == null && threadContainer3.threadable == null) {
/*     */ 
/*     */             
/* 394 */             ThreadContainer threadContainer5 = threadContainer.child;
/* 395 */             while (threadContainer5 != null && threadContainer5.next != null) {
/* 396 */               threadContainer5 = threadContainer5.next;
/*     */             }
/*     */ 
/*     */             
/* 400 */             if (threadContainer5 != null) {
/* 401 */               threadContainer5.next = threadContainer3.child;
/*     */             }
/*     */             
/* 404 */             for (threadContainer5 = threadContainer3.child; threadContainer5 != null; threadContainer5 = threadContainer5.next) {
/* 405 */               threadContainer5.parent = threadContainer;
/*     */             }
/*     */             
/* 408 */             threadContainer3.child = null;
/* 409 */           } else if (threadContainer.threadable == null || (threadContainer3.threadable != null && threadContainer3.threadable
/*     */ 
/*     */             
/* 412 */             .subjectIsReply() && 
/* 413 */             !threadContainer.threadable.subjectIsReply())) {
/*     */             
/* 415 */             threadContainer3.parent = threadContainer;
/* 416 */             threadContainer3.next = threadContainer.child;
/* 417 */             threadContainer.child = threadContainer3;
/*     */           }
/*     */           else {
/*     */             
/* 421 */             ThreadContainer threadContainer5 = new ThreadContainer();
/* 422 */             threadContainer5.threadable = threadContainer.threadable;
/* 423 */             threadContainer5.child = threadContainer.child;
/*     */             
/* 425 */             ThreadContainer threadContainer6 = threadContainer5.child;
/* 426 */             for (; threadContainer6 != null; 
/* 427 */               threadContainer6 = threadContainer6.next)
/*     */             {
/* 429 */               threadContainer6.parent = threadContainer5;
/*     */             }
/*     */             
/* 432 */             threadContainer.threadable = null;
/* 433 */             threadContainer.child = null;
/*     */             
/* 435 */             threadContainer3.parent = threadContainer;
/* 436 */             threadContainer5.parent = threadContainer;
/*     */ 
/*     */             
/* 439 */             threadContainer.child = threadContainer3;
/* 440 */             threadContainer3.next = threadContainer5;
/*     */           } 
/*     */           
/* 443 */           threadContainer3 = threadContainer2;
/*     */         } 
/*     */       } 
/* 446 */     }  hashMap.clear();
/* 447 */     hashMap = null;
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
/*     */   @Deprecated
/*     */   public Threadable thread(Threadable[] paramArrayOfThreadable) {
/* 463 */     if (paramArrayOfThreadable == null) {
/* 464 */       return null;
/*     */     }
/* 466 */     return thread(Arrays.asList(paramArrayOfThreadable));
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\net\nntp\Threader.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */