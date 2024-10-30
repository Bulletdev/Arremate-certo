/*      */ package org.h2.api;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class ErrorCode
/*      */ {
/*      */   public static final int NO_DATA_AVAILABLE = 2000;
/*      */   public static final int INVALID_PARAMETER_COUNT_2 = 7001;
/*      */   public static final int ERROR_OPENING_DATABASE_1 = 8000;
/*      */   public static final int COLUMN_COUNT_DOES_NOT_MATCH = 21002;
/*      */   public static final int VALUE_TOO_LONG_2 = 22001;
/*      */   public static final int NUMERIC_VALUE_OUT_OF_RANGE_1 = 22003;
/*      */   public static final int INVALID_DATETIME_CONSTANT_2 = 22007;
/*      */   public static final int DIVISION_BY_ZERO_1 = 22012;
/*      */   public static final int DATA_CONVERSION_ERROR_1 = 22018;
/*      */   public static final int LIKE_ESCAPE_ERROR_1 = 22025;
/*      */   public static final int NULL_NOT_ALLOWED = 23502;
/*      */   public static final int REFERENTIAL_INTEGRITY_VIOLATED_CHILD_EXISTS_1 = 23503;
/*      */   public static final int DUPLICATE_KEY_1 = 23505;
/*      */   public static final int REFERENTIAL_INTEGRITY_VIOLATED_PARENT_MISSING_1 = 23506;
/*      */   public static final int NO_DEFAULT_SET_1 = 23507;
/*      */   public static final int CHECK_CONSTRAINT_VIOLATED_1 = 23513;
/*      */   public static final int CHECK_CONSTRAINT_INVALID = 23514;
/*      */   public static final int WRONG_USER_OR_PASSWORD = 28000;
/*      */   public static final int DEADLOCK_1 = 40001;
/*      */   public static final int SYNTAX_ERROR_1 = 42000;
/*      */   public static final int SYNTAX_ERROR_2 = 42001;
/*      */   public static final int TABLE_OR_VIEW_ALREADY_EXISTS_1 = 42101;
/*      */   public static final int TABLE_OR_VIEW_NOT_FOUND_1 = 42102;
/*      */   public static final int INDEX_ALREADY_EXISTS_1 = 42111;
/*      */   public static final int INDEX_NOT_FOUND_1 = 42112;
/*      */   public static final int DUPLICATE_COLUMN_NAME_1 = 42121;
/*      */   public static final int COLUMN_NOT_FOUND_1 = 42122;
/*      */   public static final int GENERAL_ERROR_1 = 50000;
/*      */   public static final int UNKNOWN_DATA_TYPE_1 = 50004;
/*      */   public static final int FEATURE_NOT_SUPPORTED_1 = 50100;
/*      */   public static final int LOCK_TIMEOUT_1 = 50200;
/*      */   public static final int STATEMENT_WAS_CANCELED = 57014;
/*      */   public static final int FUNCTION_MUST_RETURN_RESULT_SET_1 = 90000;
/*      */   public static final int METHOD_NOT_ALLOWED_FOR_QUERY = 90001;
/*      */   public static final int METHOD_ONLY_ALLOWED_FOR_QUERY = 90002;
/*      */   public static final int HEX_STRING_ODD_1 = 90003;
/*      */   public static final int HEX_STRING_WRONG_1 = 90004;
/*      */   public static final int TRIGGER_SELECT_AND_ROW_BASED_NOT_SUPPORTED = 90005;
/*      */   public static final int SEQUENCE_EXHAUSTED = 90006;
/*      */   public static final int OBJECT_CLOSED = 90007;
/*      */   public static final int INVALID_VALUE_2 = 90008;
/*      */   public static final int SEQUENCE_ATTRIBUTES_INVALID = 90009;
/*      */   public static final int INVALID_TO_CHAR_FORMAT = 90010;
/*      */   public static final int URL_RELATIVE_TO_CWD = 90011;
/*      */   public static final int PARAMETER_NOT_SET_1 = 90012;
/*      */   public static final int DATABASE_NOT_FOUND_1 = 90013;
/*      */   public static final int PARSE_ERROR_1 = 90014;
/*      */   public static final int SUM_OR_AVG_ON_WRONG_DATATYPE_1 = 90015;
/*      */   public static final int MUST_GROUP_BY_COLUMN_1 = 90016;
/*      */   public static final int SECOND_PRIMARY_KEY = 90017;
/*      */   public static final int TRACE_CONNECTION_NOT_CLOSED = 90018;
/*      */   public static final int CANNOT_DROP_CURRENT_USER = 90019;
/*      */   public static final int DATABASE_ALREADY_OPEN_1 = 90020;
/*      */   public static final int UNSUPPORTED_SETTING_COMBINATION = 90021;
/*      */   public static final int FUNCTION_NOT_FOUND_1 = 90022;
/*      */   public static final int COLUMN_MUST_NOT_BE_NULLABLE_1 = 90023;
/*      */   public static final int FILE_RENAME_FAILED_2 = 90024;
/*      */   public static final int FILE_DELETE_FAILED_1 = 90025;
/*      */   public static final int SERIALIZATION_FAILED_1 = 90026;
/*      */   public static final int DESERIALIZATION_FAILED_1 = 90027;
/*      */   public static final int IO_EXCEPTION_1 = 90028;
/*      */   public static final int NOT_ON_UPDATABLE_ROW = 90029;
/*      */   public static final int FILE_CORRUPTED_1 = 90030;
/*      */   public static final int IO_EXCEPTION_2 = 90031;
/*      */   public static final int USER_NOT_FOUND_1 = 90032;
/*      */   public static final int USER_ALREADY_EXISTS_1 = 90033;
/*      */   public static final int TRACE_FILE_ERROR_2 = 90034;
/*      */   public static final int SEQUENCE_ALREADY_EXISTS_1 = 90035;
/*      */   public static final int SEQUENCE_NOT_FOUND_1 = 90036;
/*      */   public static final int VIEW_NOT_FOUND_1 = 90037;
/*      */   public static final int VIEW_ALREADY_EXISTS_1 = 90038;
/*      */   public static final int LOB_CLOSED_ON_TIMEOUT_1 = 90039;
/*      */   public static final int ADMIN_RIGHTS_REQUIRED = 90040;
/*      */   public static final int TRIGGER_ALREADY_EXISTS_1 = 90041;
/*      */   public static final int TRIGGER_NOT_FOUND_1 = 90042;
/*      */   public static final int ERROR_CREATING_TRIGGER_OBJECT_3 = 90043;
/*      */   public static final int ERROR_EXECUTING_TRIGGER_3 = 90044;
/*      */   public static final int CONSTRAINT_ALREADY_EXISTS_1 = 90045;
/*      */   public static final int URL_FORMAT_ERROR_2 = 90046;
/*      */   public static final int DRIVER_VERSION_ERROR_2 = 90047;
/*      */   public static final int FILE_VERSION_ERROR_1 = 90048;
/*      */   public static final int FILE_ENCRYPTION_ERROR_1 = 90049;
/*      */   public static final int WRONG_PASSWORD_FORMAT = 90050;
/*      */   public static final int INVALID_VALUE_SCALE_PRECISION = 90051;
/*      */   public static final int SUBQUERY_IS_NOT_SINGLE_COLUMN = 90052;
/*      */   public static final int SCALAR_SUBQUERY_CONTAINS_MORE_THAN_ONE_ROW = 90053;
/*      */   public static final int INVALID_USE_OF_AGGREGATE_FUNCTION_1 = 90054;
/*      */   public static final int UNSUPPORTED_CIPHER = 90055;
/*      */   public static final int INVALID_TO_DATE_FORMAT = 90056;
/*      */   public static final int CONSTRAINT_NOT_FOUND_1 = 90057;
/*      */   public static final int COMMIT_ROLLBACK_NOT_ALLOWED = 90058;
/*      */   public static final int AMBIGUOUS_COLUMN_NAME_1 = 90059;
/*      */   public static final int UNSUPPORTED_LOCK_METHOD_1 = 90060;
/*      */   public static final int EXCEPTION_OPENING_PORT_2 = 90061;
/*      */   public static final int FILE_CREATION_FAILED_1 = 90062;
/*      */   public static final int SAVEPOINT_IS_INVALID_1 = 90063;
/*      */   public static final int SAVEPOINT_IS_UNNAMED = 90064;
/*      */   public static final int SAVEPOINT_IS_NAMED = 90065;
/*      */   public static final int DUPLICATE_PROPERTY_1 = 90066;
/*      */   public static final int CONNECTION_BROKEN_1 = 90067;
/*      */   public static final int ORDER_BY_NOT_IN_RESULT = 90068;
/*      */   public static final int ROLE_ALREADY_EXISTS_1 = 90069;
/*      */   public static final int ROLE_NOT_FOUND_1 = 90070;
/*      */   public static final int USER_OR_ROLE_NOT_FOUND_1 = 90071;
/*      */   public static final int ROLES_AND_RIGHT_CANNOT_BE_MIXED = 90072;
/*      */   public static final int METHODS_MUST_HAVE_DIFFERENT_PARAMETER_COUNTS_2 = 90073;
/*      */   public static final int ROLE_ALREADY_GRANTED_1 = 90074;
/*      */   public static final int COLUMN_IS_PART_OF_INDEX_1 = 90075;
/*      */   public static final int FUNCTION_ALIAS_ALREADY_EXISTS_1 = 90076;
/*      */   public static final int FUNCTION_ALIAS_NOT_FOUND_1 = 90077;
/*      */   public static final int SCHEMA_ALREADY_EXISTS_1 = 90078;
/*      */   public static final int SCHEMA_NOT_FOUND_1 = 90079;
/*      */   public static final int SCHEMA_NAME_MUST_MATCH = 90080;
/*      */   public static final int COLUMN_CONTAINS_NULL_VALUES_1 = 90081;
/*      */   public static final int SEQUENCE_BELONGS_TO_A_TABLE_1 = 90082;
/*      */   public static final int COLUMN_IS_REFERENCED_1 = 90083;
/*      */   public static final int CANNOT_DROP_LAST_COLUMN = 90084;
/*      */   public static final int INDEX_BELONGS_TO_CONSTRAINT_2 = 90085;
/*      */   public static final int CLASS_NOT_FOUND_1 = 90086;
/*      */   public static final int METHOD_NOT_FOUND_1 = 90087;
/*      */   public static final int UNKNOWN_MODE_1 = 90088;
/*      */   public static final int COLLATION_CHANGE_WITH_DATA_TABLE_1 = 90089;
/*      */   public static final int SCHEMA_CAN_NOT_BE_DROPPED_1 = 90090;
/*      */   public static final int ROLE_CAN_NOT_BE_DROPPED_1 = 90091;
/*      */   public static final int CLUSTER_ERROR_DATABASE_RUNS_ALONE = 90093;
/*      */   public static final int CLUSTER_ERROR_DATABASE_RUNS_CLUSTERED_1 = 90094;
/*      */   public static final int STRING_FORMAT_ERROR_1 = 90095;
/*      */   public static final int NOT_ENOUGH_RIGHTS_FOR_1 = 90096;
/*      */   public static final int DATABASE_IS_READ_ONLY = 90097;
/*      */   public static final int DATABASE_IS_CLOSED = 90098;
/*      */   public static final int ERROR_SETTING_DATABASE_EVENT_LISTENER_2 = 90099;
/*      */   public static final int WRONG_XID_FORMAT_1 = 90101;
/*      */   public static final int UNSUPPORTED_COMPRESSION_OPTIONS_1 = 90102;
/*      */   public static final int UNSUPPORTED_COMPRESSION_ALGORITHM_1 = 90103;
/*      */   public static final int COMPRESSION_ERROR = 90104;
/*      */   public static final int EXCEPTION_IN_FUNCTION_1 = 90105;
/*      */   public static final int CANNOT_TRUNCATE_1 = 90106;
/*      */   public static final int CANNOT_DROP_2 = 90107;
/*      */   public static final int OUT_OF_MEMORY = 90108;
/*      */   public static final int VIEW_IS_INVALID_2 = 90109;
/*      */   public static final int ERROR_ACCESSING_LINKED_TABLE_2 = 90111;
/*      */   public static final int ROW_NOT_FOUND_WHEN_DELETING_1 = 90112;
/*      */   public static final int UNSUPPORTED_SETTING_1 = 90113;
/*      */   public static final int CONSTANT_ALREADY_EXISTS_1 = 90114;
/*      */   public static final int CONSTANT_NOT_FOUND_1 = 90115;
/*      */   public static final int LITERALS_ARE_NOT_ALLOWED = 90116;
/*      */   public static final int REMOTE_CONNECTION_NOT_ALLOWED = 90117;
/*      */   public static final int CANNOT_DROP_TABLE_1 = 90118;
/*      */   public static final int USER_DATA_TYPE_ALREADY_EXISTS_1 = 90119;
/*      */   public static final int USER_DATA_TYPE_NOT_FOUND_1 = 90120;
/*      */   public static final int DATABASE_CALLED_AT_SHUTDOWN = 90121;
/*      */   public static final int CANNOT_MIX_INDEXED_AND_UNINDEXED_PARAMS = 90123;
/*      */   public static final int FILE_NOT_FOUND_1 = 90124;
/*      */   public static final int INVALID_CLASS_2 = 90125;
/*      */   public static final int DATABASE_IS_NOT_PERSISTENT = 90126;
/*      */   public static final int RESULT_SET_NOT_UPDATABLE = 90127;
/*      */   public static final int RESULT_SET_NOT_SCROLLABLE = 90128;
/*      */   public static final int TRANSACTION_NOT_FOUND_1 = 90129;
/*      */   public static final int METHOD_NOT_ALLOWED_FOR_PREPARED_STATEMENT = 90130;
/*      */   public static final int CONCURRENT_UPDATE_1 = 90131;
/*      */   public static final int AGGREGATE_NOT_FOUND_1 = 90132;
/*      */   public static final int CANNOT_CHANGE_SETTING_WHEN_OPEN_1 = 90133;
/*      */   public static final int ACCESS_DENIED_TO_CLASS_1 = 90134;
/*      */   public static final int DATABASE_IS_IN_EXCLUSIVE_MODE = 90135;
/*      */   public static final int UNSUPPORTED_OUTER_JOIN_CONDITION_1 = 90136;
/*      */   public static final int CAN_ONLY_ASSIGN_TO_VARIABLE_1 = 90137;
/*      */   public static final int INVALID_DATABASE_NAME_1 = 90138;
/*      */   public static final int PUBLIC_STATIC_JAVA_METHOD_NOT_FOUND_1 = 90139;
/*      */   public static final int RESULT_SET_READONLY = 90140;
/*      */   public static final int JAVA_OBJECT_SERIALIZER_CHANGE_WITH_DATA_TABLE = 90141;
/*      */   public static final int STEP_SIZE_MUST_NOT_BE_ZERO = 90142;
/*      */   
/*      */   public static boolean isCommon(int paramInt) {
/* 1943 */     switch (paramInt) {
/*      */       case 2000:
/*      */       case 22001:
/*      */       case 22003:
/*      */       case 22018:
/*      */       case 23502:
/*      */       case 23503:
/*      */       case 23505:
/*      */       case 23506:
/*      */       case 42000:
/*      */       case 42001:
/*      */       case 42101:
/*      */       case 42102:
/*      */       case 50200:
/*      */       case 90007:
/*      */       case 90076:
/* 1959 */         return true;
/*      */     } 
/* 1961 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String getState(int paramInt) {
/* 1971 */     switch (paramInt) {
/*      */       
/*      */       case 2000:
/* 1974 */         return "02000";
/*      */       
/*      */       case 7001:
/* 1977 */         return "07001";
/*      */       
/*      */       case 8000:
/* 1980 */         return "08000";
/*      */       
/*      */       case 21002:
/* 1983 */         return "21S02";
/*      */       
/*      */       case 42101:
/* 1986 */         return "42S01";
/* 1987 */       case 42102: return "42S02";
/* 1988 */       case 42111: return "42S11";
/* 1989 */       case 42112: return "42S12";
/* 1990 */       case 42121: return "42S21";
/* 1991 */       case 42122: return "42S22";
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       case 50000:
/* 1998 */         return "HY000";
/* 1999 */       case 50004: return "HY004";
/*      */       case 50100:
/* 2001 */         return "HYC00";
/* 2002 */       case 50200: return "HYT00";
/*      */     } 
/* 2004 */     return "" + paramInt;
/*      */   }
/*      */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\api\ErrorCode.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */