/*     */ package org.apache.commons.lang3;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.Collections;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ThreadUtils
/*     */ {
/*     */   public static Thread findThreadById(long paramLong, ThreadGroup paramThreadGroup) {
/*  53 */     Validate.notNull(paramThreadGroup, "The thread group must not be null", new Object[0]);
/*  54 */     Thread thread = findThreadById(paramLong);
/*  55 */     if (thread != null && paramThreadGroup.equals(thread.getThreadGroup())) {
/*  56 */       return thread;
/*     */     }
/*  58 */     return null;
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
/*     */   public static Thread findThreadById(long paramLong, String paramString) {
/*  76 */     Validate.notNull(paramString, "The thread group name must not be null", new Object[0]);
/*  77 */     Thread thread = findThreadById(paramLong);
/*  78 */     if (thread != null && thread.getThreadGroup() != null && thread.getThreadGroup().getName().equals(paramString)) {
/*  79 */       return thread;
/*     */     }
/*  81 */     return null;
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
/*     */   public static Collection<Thread> findThreadsByName(String paramString, ThreadGroup paramThreadGroup) {
/*  99 */     return findThreads(paramThreadGroup, false, new NamePredicate(paramString));
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
/*     */   public static Collection<Thread> findThreadsByName(String paramString1, String paramString2) {
/* 117 */     Validate.notNull(paramString1, "The thread name must not be null", new Object[0]);
/* 118 */     Validate.notNull(paramString2, "The thread group name must not be null", new Object[0]);
/*     */     
/* 120 */     Collection<ThreadGroup> collection = findThreadGroups(new NamePredicate(paramString2));
/*     */     
/* 122 */     if (collection.isEmpty()) {
/* 123 */       return Collections.emptyList();
/*     */     }
/*     */     
/* 126 */     ArrayList<Thread> arrayList = new ArrayList();
/* 127 */     NamePredicate namePredicate = new NamePredicate(paramString1);
/* 128 */     for (ThreadGroup threadGroup : collection) {
/* 129 */       arrayList.addAll(findThreads(threadGroup, false, namePredicate));
/*     */     }
/* 131 */     return Collections.unmodifiableCollection(arrayList);
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
/*     */   public static Collection<ThreadGroup> findThreadGroupsByName(String paramString) {
/* 147 */     return findThreadGroups(new NamePredicate(paramString));
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
/*     */   public static Collection<ThreadGroup> getAllThreadGroups() {
/* 161 */     return findThreadGroups(ALWAYS_TRUE_PREDICATE);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static ThreadGroup getSystemThreadGroup() {
/* 172 */     ThreadGroup threadGroup = Thread.currentThread().getThreadGroup();
/* 173 */     while (threadGroup.getParent() != null) {
/* 174 */       threadGroup = threadGroup.getParent();
/*     */     }
/* 176 */     return threadGroup;
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
/*     */   public static Collection<Thread> getAllThreads() {
/* 190 */     return findThreads(ALWAYS_TRUE_PREDICATE);
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
/*     */   public static Collection<Thread> findThreadsByName(String paramString) {
/* 206 */     return findThreads(new NamePredicate(paramString));
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
/*     */   public static Thread findThreadById(long paramLong) {
/* 222 */     Collection<Thread> collection = findThreads(new ThreadIdPredicate(paramLong));
/* 223 */     return collection.isEmpty() ? null : collection.iterator().next();
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 272 */   public static final AlwaysTruePredicate ALWAYS_TRUE_PREDICATE = new AlwaysTruePredicate();
/*     */   
/*     */   @FunctionalInterface
/*     */   public static interface ThreadPredicate {
/*     */     boolean test(Thread param1Thread); }
/*     */   
/*     */   @FunctionalInterface
/*     */   public static interface ThreadGroupPredicate {
/*     */     boolean test(ThreadGroup param1ThreadGroup); }
/*     */   
/*     */   private static final class AlwaysTruePredicate implements ThreadGroupPredicate, ThreadPredicate {
/*     */     public boolean test(ThreadGroup param1ThreadGroup) {
/* 284 */       return true;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean test(Thread param1Thread) {
/* 289 */       return true;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private AlwaysTruePredicate() {}
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static class NamePredicate
/*     */     implements ThreadGroupPredicate, ThreadPredicate
/*     */   {
/*     */     private final String name;
/*     */ 
/*     */ 
/*     */     
/*     */     public NamePredicate(String param1String) {
/* 308 */       Validate.notNull(param1String, "The name must not be null", new Object[0]);
/* 309 */       this.name = param1String;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean test(ThreadGroup param1ThreadGroup) {
/* 314 */       return (param1ThreadGroup != null && param1ThreadGroup.getName().equals(this.name));
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean test(Thread param1Thread) {
/* 319 */       return (param1Thread != null && param1Thread.getName().equals(this.name));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static class ThreadIdPredicate
/*     */     implements ThreadPredicate
/*     */   {
/*     */     private final long threadId;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public ThreadIdPredicate(long param1Long) {
/* 338 */       if (param1Long <= 0L) {
/* 339 */         throw new IllegalArgumentException("The thread id must be greater than zero");
/*     */       }
/* 341 */       this.threadId = param1Long;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean test(Thread param1Thread) {
/* 346 */       return (param1Thread != null && param1Thread.getId() == this.threadId);
/*     */     }
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
/*     */   public static Collection<Thread> findThreads(ThreadPredicate paramThreadPredicate) {
/* 363 */     return findThreads(getSystemThreadGroup(), true, paramThreadPredicate);
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
/*     */   public static Collection<ThreadGroup> findThreadGroups(ThreadGroupPredicate paramThreadGroupPredicate) {
/* 378 */     return findThreadGroups(getSystemThreadGroup(), true, paramThreadGroupPredicate);
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
/*     */   public static Collection<Thread> findThreads(ThreadGroup paramThreadGroup, boolean paramBoolean, ThreadPredicate paramThreadPredicate) {
/*     */     Thread[] arrayOfThread;
/* 393 */     Validate.notNull(paramThreadGroup, "The group must not be null", new Object[0]);
/* 394 */     Validate.notNull(paramThreadPredicate, "The predicate must not be null", new Object[0]);
/*     */     
/* 396 */     int i = paramThreadGroup.activeCount();
/*     */     
/*     */     do {
/* 399 */       arrayOfThread = new Thread[i + i / 2 + 1];
/* 400 */       i = paramThreadGroup.enumerate(arrayOfThread, paramBoolean);
/*     */     }
/* 402 */     while (i >= arrayOfThread.length);
/*     */     
/* 404 */     ArrayList<Thread> arrayList = new ArrayList(i);
/* 405 */     for (byte b = 0; b < i; b++) {
/* 406 */       if (paramThreadPredicate.test(arrayOfThread[b])) {
/* 407 */         arrayList.add(arrayOfThread[b]);
/*     */       }
/*     */     } 
/* 410 */     return Collections.unmodifiableCollection(arrayList);
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
/*     */   public static Collection<ThreadGroup> findThreadGroups(ThreadGroup paramThreadGroup, boolean paramBoolean, ThreadGroupPredicate paramThreadGroupPredicate) {
/*     */     ThreadGroup[] arrayOfThreadGroup;
/* 425 */     Validate.notNull(paramThreadGroup, "The group must not be null", new Object[0]);
/* 426 */     Validate.notNull(paramThreadGroupPredicate, "The predicate must not be null", new Object[0]);
/*     */     
/* 428 */     int i = paramThreadGroup.activeGroupCount();
/*     */     
/*     */     do {
/* 431 */       arrayOfThreadGroup = new ThreadGroup[i + i / 2 + 1];
/* 432 */       i = paramThreadGroup.enumerate(arrayOfThreadGroup, paramBoolean);
/*     */     }
/* 434 */     while (i >= arrayOfThreadGroup.length);
/*     */     
/* 436 */     ArrayList<ThreadGroup> arrayList = new ArrayList(i);
/* 437 */     for (byte b = 0; b < i; b++) {
/* 438 */       if (paramThreadGroupPredicate.test(arrayOfThreadGroup[b])) {
/* 439 */         arrayList.add(arrayOfThreadGroup[b]);
/*     */       }
/*     */     } 
/* 442 */     return Collections.unmodifiableCollection(arrayList);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\lang3\ThreadUtils.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */