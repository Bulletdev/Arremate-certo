/*     */ package org.apache.poi.xwpf.usermodel;
/*     */ 
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public enum Borders
/*     */ {
/*  42 */   NIL(1),
/*     */   
/*  44 */   NONE(2),
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  50 */   SINGLE(3),
/*     */   
/*  52 */   THICK(4),
/*     */   
/*  54 */   DOUBLE(5),
/*     */   
/*  56 */   DOTTED(6),
/*     */   
/*  58 */   DASHED(7),
/*     */   
/*  60 */   DOT_DASH(8),
/*     */   
/*  62 */   DOT_DOT_DASH(9),
/*     */   
/*  64 */   TRIPLE(10),
/*     */   
/*  66 */   THIN_THICK_SMALL_GAP(11),
/*     */   
/*  68 */   THICK_THIN_SMALL_GAP(12),
/*     */   
/*  70 */   THIN_THICK_THIN_SMALL_GAP(13),
/*     */   
/*  72 */   THIN_THICK_MEDIUM_GAP(14),
/*     */   
/*  74 */   THICK_THIN_MEDIUM_GAP(15),
/*     */   
/*  76 */   THIN_THICK_THIN_MEDIUM_GAP(16),
/*     */   
/*  78 */   THIN_THICK_LARGE_GAP(17),
/*     */   
/*  80 */   THICK_THIN_LARGE_GAP(18),
/*     */   
/*  82 */   THIN_THICK_THIN_LARGE_GAP(19),
/*     */   
/*  84 */   WAVE(20),
/*     */   
/*  86 */   DOUBLE_WAVE(21),
/*     */   
/*  88 */   DASH_SMALL_GAP(22),
/*     */   
/*  90 */   DASH_DOT_STROKED(23),
/*     */   
/*  92 */   THREE_D_EMBOSS(24),
/*     */   
/*  94 */   THREE_D_ENGRAVE(25),
/*     */   
/*  96 */   OUTSET(26),
/*     */   
/*  98 */   INSET(27),
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 103 */   APPLES(28),
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 108 */   ARCHED_SCALLOPS(29),
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 113 */   BABY_PACIFIER(30),
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 118 */   BABY_RATTLE(31),
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 124 */   BALLOONS_3_COLORS(32),
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 130 */   BALLOONS_HOT_AIR(33),
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 136 */   BASIC_BLACK_DASHES(34),
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 142 */   BASIC_BLACK_DOTS(35),
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 148 */   BASIC_BLACK_SQUARES(36),
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 154 */   BASIC_THIN_LINES(37),
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 160 */   BASIC_WHITE_DASHES(38),
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 166 */   BASIC_WHITE_DOTS(39),
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 172 */   BASIC_WHITE_SQUARES(40),
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 178 */   BASIC_WIDE_INLINE(41),
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 184 */   BASIC_WIDE_MIDLINE(42),
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 190 */   BASIC_WIDE_OUTLINE(43),
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 195 */   BATS(44),
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 200 */   BIRDS(45),
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 205 */   BIRDS_FLIGHT(46),
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 210 */   CABINS(47),
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 215 */   CAKE_SLICE(48),
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 220 */   CANDY_CORN(49),
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 226 */   CELTIC_KNOTWORK(50),
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 234 */   CERTIFICATE_BANNER(51),
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 240 */   CHAIN_LINK(52),
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 246 */   CHAMPAGNE_BOTTLE(53),
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 251 */   CHECKED_BAR_BLACK(54),
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 257 */   CHECKED_BAR_COLOR(55),
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 262 */   CHECKERED(56),
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 268 */   CHRISTMAS_TREE(57),
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 274 */   CIRCLES_LINES(58),
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 280 */   CIRCLES_RECTANGLES(59),
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 285 */   CLASSICAL_WAVE(60),
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 290 */   CLOCKS(61),
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 295 */   COMPASS(62),
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 300 */   CONFETTI(63),
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 305 */   CONFETTI_GRAYS(64),
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 310 */   CONFETTI_OUTLINE(65),
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 316 */   CONFETTI_STREAMERS(66),
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 321 */   CONFETTI_WHITE(67),
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 326 */   CORNER_TRIANGLES(68),
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 331 */   COUPON_CUTOUT_DASHES(69),
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 336 */   COUPON_CUTOUT_DOTS(70),
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 342 */   CRAZY_MAZE(71),
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 347 */   CREATURES_BUTTERFLY(72),
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 352 */   CREATURES_FISH(73),
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 357 */   CREATURES_INSECTS(74),
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 362 */   CREATURES_LADY_BUG(75),
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 368 */   CROSS_STITCH(76),
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 373 */   CUP(77),
/*     */   
/* 375 */   DECO_ARCH(78),
/*     */   
/* 377 */   DECO_ARCH_COLOR(79),
/*     */   
/* 379 */   DECO_BLOCKS(80),
/*     */   
/* 381 */   DIAMONDS_GRAY(81),
/*     */   
/* 383 */   DOUBLE_D(82),
/*     */   
/* 385 */   DOUBLE_DIAMONDS(83),
/*     */   
/* 387 */   EARTH_1(84),
/*     */   
/* 389 */   EARTH_2(85),
/*     */   
/* 391 */   ECLIPSING_SQUARES_1(86),
/*     */   
/* 393 */   ECLIPSING_SQUARES_2(87),
/*     */   
/* 395 */   EGGS_BLACK(88),
/*     */   
/* 397 */   FANS(89),
/*     */   
/* 399 */   FILM(90),
/*     */   
/* 401 */   FIRECRACKERS(91),
/*     */   
/* 403 */   FLOWERS_BLOCK_PRINT(92),
/*     */   
/* 405 */   FLOWERS_DAISIES(93),
/*     */   
/* 407 */   FLOWERS_MODERN_1(94),
/*     */   
/* 409 */   FLOWERS_MODERN_2(95),
/*     */   
/* 411 */   FLOWERS_PANSY(96),
/*     */   
/* 413 */   FLOWERS_RED_ROSE(97),
/*     */   
/* 415 */   FLOWERS_ROSES(98),
/*     */   
/* 417 */   FLOWERS_TEACUP(99),
/*     */   
/* 419 */   FLOWERS_TINY(100),
/*     */   
/* 421 */   GEMS(101),
/*     */   
/* 423 */   GINGERBREAD_MAN(102),
/*     */   
/* 425 */   GRADIENT(103),
/*     */   
/* 427 */   HANDMADE_1(104),
/*     */   
/* 429 */   HANDMADE_2(105),
/*     */   
/* 431 */   HEART_BALLOON(106),
/*     */   
/* 433 */   HEART_GRAY(107),
/*     */   
/* 435 */   HEARTS(108),
/*     */   
/* 437 */   HEEBIE_JEEBIES(109),
/*     */   
/* 439 */   HOLLY(110),
/*     */   
/* 441 */   HOUSE_FUNKY(111),
/*     */   
/* 443 */   HYPNOTIC(112),
/*     */   
/* 445 */   ICE_CREAM_CONES(113),
/*     */   
/* 447 */   LIGHT_BULB(114),
/*     */   
/* 449 */   LIGHTNING_1(115),
/*     */   
/* 451 */   LIGHTNING_2(116),
/*     */   
/* 453 */   MAP_PINS(117),
/*     */   
/* 455 */   MAPLE_LEAF(118),
/*     */   
/* 457 */   MAPLE_MUFFINS(119),
/*     */   
/* 459 */   MARQUEE(120),
/*     */   
/* 461 */   MARQUEE_TOOTHED(121),
/*     */   
/* 463 */   MOONS(122),
/*     */   
/* 465 */   MOSAIC(123),
/*     */   
/* 467 */   MUSIC_NOTES(124),
/*     */   
/* 469 */   NORTHWEST(125),
/*     */   
/* 471 */   OVALS(126),
/*     */   
/* 473 */   PACKAGES(127),
/*     */   
/* 475 */   PALMS_BLACK(128),
/*     */   
/* 477 */   PALMS_COLOR(129),
/*     */   
/* 479 */   PAPER_CLIPS(130),
/*     */   
/* 481 */   PAPYRUS(131),
/*     */   
/* 483 */   PARTY_FAVOR(132),
/*     */   
/* 485 */   PARTY_GLASS(133),
/*     */   
/* 487 */   PENCILS(134),
/*     */   
/* 489 */   PEOPLE(135),
/*     */   
/* 491 */   PEOPLE_WAVING(136),
/*     */   
/* 493 */   PEOPLE_HATS(137),
/*     */   
/* 495 */   POINSETTIAS(138),
/*     */   
/* 497 */   POSTAGE_STAMP(139),
/*     */   
/* 499 */   PUMPKIN_1(140),
/*     */   
/* 501 */   PUSH_PIN_NOTE_2(141),
/*     */   
/* 503 */   PUSH_PIN_NOTE_1(142),
/*     */   
/* 505 */   PYRAMIDS(143),
/*     */   
/* 507 */   PYRAMIDS_ABOVE(144),
/*     */   
/* 509 */   QUADRANTS(145),
/*     */   
/* 511 */   RINGS(146),
/*     */   
/* 513 */   SAFARI(147),
/*     */   
/* 515 */   SAWTOOTH(148),
/*     */   
/* 517 */   SAWTOOTH_GRAY(149),
/*     */   
/* 519 */   SCARED_CAT(150),
/*     */   
/* 521 */   SEATTLE(151),
/*     */   
/* 523 */   SHADOWED_SQUARES(152),
/*     */   
/* 525 */   SHARKS_TEETH(153),
/*     */   
/* 527 */   SHOREBIRD_TRACKS(154),
/*     */   
/* 529 */   SKYROCKET(155),
/*     */   
/* 531 */   SNOWFLAKE_FANCY(156),
/*     */   
/* 533 */   SNOWFLAKES(157),
/*     */   
/* 535 */   SOMBRERO(158),
/*     */   
/* 537 */   SOUTHWEST(159),
/*     */   
/* 539 */   STARS(160),
/*     */   
/* 541 */   STARS_TOP(161),
/*     */   
/* 543 */   STARS_3_D(162),
/*     */   
/* 545 */   STARS_BLACK(163),
/*     */   
/* 547 */   STARS_SHADOWED(164),
/*     */   
/* 549 */   SUN(165),
/*     */   
/* 551 */   SWIRLIGIG(166),
/*     */   
/* 553 */   TORN_PAPER(167),
/*     */   
/* 555 */   TORN_PAPER_BLACK(168),
/*     */   
/* 557 */   TREES(169),
/*     */   
/* 559 */   TRIANGLE_PARTY(170),
/*     */   
/* 561 */   TRIANGLES(171),
/*     */   
/* 563 */   TRIBAL_1(172),
/*     */   
/* 565 */   TRIBAL_2(173),
/*     */   
/* 567 */   TRIBAL_3(174),
/*     */   
/* 569 */   TRIBAL_4(175),
/*     */   
/* 571 */   TRIBAL_5(176),
/*     */   
/* 573 */   TRIBAL_6(177),
/*     */   
/* 575 */   TWISTED_LINES_1(178),
/*     */   
/* 577 */   TWISTED_LINES_2(179),
/*     */   
/* 579 */   VINE(180),
/*     */   
/* 581 */   WAVELINE(181),
/*     */   
/* 583 */   WEAVING_ANGLES(182),
/*     */   
/* 585 */   WEAVING_BRAID(183),
/*     */   
/* 587 */   WEAVING_RIBBON(184),
/*     */   
/* 589 */   WEAVING_STRIPS(185),
/*     */   
/* 591 */   WHITE_FLOWERS(186),
/*     */   
/* 593 */   WOODWORK(187),
/*     */   
/* 595 */   X_ILLUSIONS(188),
/*     */   
/* 597 */   ZANY_TRIANGLES(189),
/*     */   
/* 599 */   ZIG_ZAG(190),
/*     */   
/* 601 */   ZIG_ZAG_STITCH(191);
/*     */   static {
/* 603 */     imap = new HashMap<Integer, Borders>();
/*     */ 
/*     */     
/* 606 */     for (Borders borders : values())
/* 607 */       imap.put(Integer.valueOf(borders.getValue()), borders); 
/*     */   }
/*     */   
/*     */   private static Map<Integer, Borders> imap;
/*     */   private final int value;
/*     */   
/*     */   Borders(int paramInt1) {
/* 614 */     this.value = paramInt1;
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
/*     */   public int getValue() {
/* 626 */     return this.value;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xwp\\usermodel\Borders.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */