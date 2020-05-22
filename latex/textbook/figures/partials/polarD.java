                  /*  File:  polarD.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class polarD extends Template {

     static {templateClass = new polarD() ; }

     public void setup() {
          filePrefix = "polarD" ;    // used as the prefix for any ps or lbl files written
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 1.5 ;      // in inches
          ysize = 1.5 ;   // in inches. 
          xmin = -2 ;
          xmax = 8 ;
          ymin = -2 ;
          ymax =  8 ;
          topmargin = 0.2 ;   // in inches
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
          fLine(xmin,0,xmax,0) ;
          fLine(0,ymin,0,ymax) ;
//          fTeXlabel(xmax,-0.3, "tr", "$x$") ;
//          fTeXlabel(-0.3, ymax, "tr", "$y$") ;

          fEnv("lineWidth", 1.0) ;
          double r = 8 ; double th = 45 ; double thrad=th*Math.PI/180.0 ;
          double x = r*Math.cos(thrad) ; double y = r*Math.sin(thrad) ; 
          fLine(0, 0,  x, y) ;
          fTeXlabel(x+0.2,y, "bl", "$\\scriptstyle f=\\cos(90^\\circ)=0$") ;

          th = 0 ;  thrad=th*Math.PI/180.0 ;
          x = r*Math.cos(thrad) ;  y = r*Math.sin(thrad) ; 
          fLine(0, 0,  x, y) ;
          fTeXlabel(x+0.2,y, "cl", "$\\scriptstyle f=\\cos(0)=1$") ;

          th = 15 ;  thrad=th*Math.PI/180.0 ;
          x = r*Math.cos(thrad) ;  y = r*Math.sin(thrad) ; 
          fLine(0, 0,  x, y) ;
          fTeXlabel(x+0.2,y, "cl", "$\\scriptstyle f=\\cos(30^\\circ)=\\sqrt{3}/2$") ;

          th = 30 ;  thrad=th*Math.PI/180.0 ;
          x = r*Math.cos(thrad) ;  y = r*Math.sin(thrad) ; 
          fLine(0, 0,  x, y) ;
          fTeXlabel(x+0.2,y, "cl", "$\\scriptstyle f=\\cos(60^\\circ)=1/2$") ;

          th = 67.5 ;  thrad=th*Math.PI/180.0 ;
          x = r*Math.cos(thrad) ;  y = r*Math.sin(thrad) ; 
          fLine(0, 0,  x, y) ;
          fTeXlabel(x+0.2,y+0.3, "cl", "$\\scriptstyle f=\\cos(135^\\circ)=-1/\\sqrt{2}$");


          th = 90 ;  thrad=th*Math.PI/180.0 ;
          x = r*Math.cos(thrad) ;  y = r*Math.sin(thrad) ; 
          fLine(0, 0,  x, y) ;
          fTeXlabel(x,y+0.2, "bc", "$\\scriptstyle f=\\cos(180^\\circ)=-1$") ;

          fEnv("psFillGray", 1.0) ;
          fEnv("lineWidth", 0.5) ;
          fDisk(0, 0, 0.3, 0.3, CLOSED+FILLED) ;

          r = 1.5 ;
          th = -30 ;  thrad=th*Math.PI/180.0 ;
          x = 1.02*r*Math.cos(thrad) ;  y = 1.02*r*Math.sin(thrad) ; 
          fDisk(0, 0, r, r, CLOSED) ;
//          fTeXlabel(x,y, "tl", "$r=\\delta$") ;
          fTeXlabel(x,y, "tl", "$r=10^{-137}$") ;
//          fTeXlabel(x,y, "tl", "$r$") ;


     }
}
