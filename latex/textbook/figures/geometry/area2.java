                  /*  File:  area2.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class area2 extends Template {

     static {templateClass = new area2() ; }

     public void setup() {
          filePrefix = "area2" ;   
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 2.4*1.5 ;      // in inches
          ysize = 1.8*1.5 ;   // in inches. 
          xmin = -20 ;
          xmax = 210 ;
          ymin = -20 ;
          ymax = 170 ;
          topmargin = 0 ;   // in inches
          bottommargin = 0 ;   // in inches
          leftmargin = 0 ;   // in inches
          rightmargin = 0 ;   // in inches
          useZoom = true ;
          useDrag = true ;
          showCoords = true ;
          showCanvasBoundary = true ;   
     }
     
     public  void prepareFigure(Figure canvas) {
         fEnv("lineWidth", 0.5) ;
         fEnv("psFillGray", 0.6) ;
         {double[] xlist = {0, 100, 100} ;
          double[] ylist = {0,   0, 50} ;
          fPolygon(xlist,ylist, 3, FILLED) ;}
         {double[] xlist = {50,  150, 50} ;
          double[] ylist = {150, 150, 100} ;
          fPolygon(xlist,ylist, 3, FILLED) ;}
         fEnv("psFillGray", 0.8) ;
         {double[] xlist = {0,   0, 50} ;
          double[] ylist = {0, 100, 100} ;
          fPolygon(xlist,ylist, 3, FILLED) ;}
         {double[] xlist = {150, 150, 100} ;
          double[] ylist = { 50, 150, 50} ;
          fPolygon(xlist,ylist, 3, FILLED) ;}

         fLine( -20, 0, 170, 0  ) ;
         fLine( 0, -20,   0, 170  ) ;
         fEnv("lineWidth", 0.8) ;
//setarrow 6 1.2 3
//          fEnv("tailHalfWidth", 3) ;
          fEnv("headHalfWidth", 1.2) ;
          fEnv("headLength", 6) ;
         fArrow( 0, 0,    100, 50  ) ;
         fArrow( 0, 0,     50, 100  ) ;
         fArrow( 100, 50, 150, 150  ) ;
         fArrow( 50, 100,  150, 150  ) ;
//setarrow 6 1.5 3
//          fEnv("tailHalfWidth", 3) ;
          fEnv("headHalfWidth", 1.5) ;
          fEnv("headLength", 6) ;
         fEnv("lineWidth", 0.5) ;
         fLine( 0, 150,   150, 150  ) ;
         fLine( 150, 0,   150, 150  ) ;
         fLine( 100, 50,  150, 50  ) ;
         fLine( 100, 50,  100, 0  ) ;
         fLine( 50, 100,   0,  100  ) ;
         fLine( 50, 100,   50, 150  ) ;


         fTeXlabel( 152, 152, "bl", "$(a+c,b+d)$"  ) ;
         fTeXlabel( 100, 52, "br", "$(a,b)$"  ) ;
         fTeXlabel( 50, 100, "tl", "$(c,d)$"  ) ;

         fLine( 100, -5,   100, -20  ) ;
         fLine( 150, -5,   150, -20  ) ;

         fArrow(  40, -12.5,  2, -12.5    ) ;
         fArrow(  60, -12.5,   98, -12.5  ) ;
         fArrow(  120, -12.5,  102, -12.5    ) ;
         fArrow(  130, -12.5,  148, -12.5  ) ;
         fTeXlabel( 50, -12.5, "cc", "$a$"  ) ;
         fTeXlabel( 125, -12.5, "cc", "$c$"  ) ;

         fLine( 155, 50,  170, 50  ) ;
         fLine( 155, 150,  170, 150  ) ;

         fArrow(  -12.5, 40, -12.5,  2   ) ;
         fArrow(  -12.5, 60, -12.5,  98  ) ;
         fArrow(  -12.5, 117, -12.5,  102   ) ;
         fArrow(  -12.5, 133, -12.5, 148  ) ;
         fTeXlabel( -12.5, 50, "cc", "$d$"  ) ;
         fTeXlabel( -12.5, 125, "cc", "$b$"  ) ;


         fLine( 50, 155,   50, 170  ) ;
         fLine( 150, 155,   150, 170  ) ;

         fArrow(  20, 162.5,  2, 162.5    ) ;
         fArrow(  30, 162.5,   48, 162.5  ) ;
         fArrow(  90, 162.5,  52, 162.5    ) ;
         fArrow(  110, 162.5,  148, 162.5  ) ;
         fTeXlabel( 25, 162.5, "cc", "$c$"  ) ;
         fTeXlabel( 100, 162.5, "cc", "$a$"  ) ;

         fLine( -5, 100,  -20, 100  ) ;
         fLine( -5, 150,  -20, 150  ) ;

         fArrow(  162.5, 17,  162.5, 2   ) ;
         fArrow(  162.5, 33,  162.5, 48  ) ;
         fArrow(  162.5, 90,  162.5, 52  ) ;
         fArrow(  162.5, 110,  162.5, 148  ) ;
         fTeXlabel( 162.5, 25, "cc", "$b$"  ) ;
         fTeXlabel( 162.5, 100, "cc", "$d$"  ) ;

     }
}
