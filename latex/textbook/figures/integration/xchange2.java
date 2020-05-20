                  /*  File:  xchange2.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class xchange2 extends Template {

     static {templateClass = new xchange2() ; }

     public void setup() {
          filePrefix = "xchange2" ;  
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 1.6 ;    
          ysize = 1.6 ;  
          xmin = -0.1 ;
          xmax =  2.1 ;
          ymin = -0.1 ;
          ymax =  2.1 ;
          topmargin = 0.0 ;   // in inches
          bottommargin = 0.0 ;   // in inches
          leftmargin = 0.0 ;   // in inches
          rightmargin = 0 ;   // in inches
          useZoom = true ;
          useDrag = true ;
          showCoords = true ;
          showCanvasBoundary = true ;   
     }
     
     public  void prepareFigure(Figure canvas) {
          double y = 0.5 ;
          double xm = 0.5*(2-y) ; double zm = 2-y ;
          {fEnv("psFillGray", 0.9) ;
           double[] xlist = { 0,  0, xm, xm} ;
           double[] ylist = { 0, zm, zm,  0} ;
           fPolygon(xlist, ylist, 4, FILLED) ;
           }
          fEnv("psFillGray", 0.0) ;

          fEnv("lineWidth", 0.5) ;
          fLine(xmin,0,xmax,0) ;
          fLine(0,ymin,0,ymax) ;
          fTeXlabel(xmax+0.05, 0, "lc", "$x$") ;
          fTeXlabel(0,ymax+0.05, "bc", "$z$") ;

          fLine(xmin,zm,xmax,zm) ;
          fTeXlabel(xmax, zm-0.04, "tr", "$z=2-Y$") ;
          fLine(xm,ymin,xm,ymax) ;
          fTeXlabel(xm+0.05, ymax+0.05, "tl", "$x=(2-Y)/2$") ;


          String Blue = "0 0.53333 0.8 setrgbcolor  " ;
          String Black = "0 0 0 setrgbcolor  " ;
          canvas.append( new fPsWrite(Blue+"\n")) ;
          fEnv("lineWidth", 2.0) ;
          {fEnv("psFillGray", 0.7) ;
           double[] xlist = { 0,  0, xm, xm} ;
           double[] ylist = { 0, zm, zm,  0} ;
           fPolygon(xlist, ylist, 4, CLOSED) ;
           }





//          fTeXlabel(-0.03,1, "rc", 
//              "$\\big(0,b(1-\\frac{z}{c})\\big)$") ;
//          fTeXlabel(1-y+0.05,y+0.04, "lc", 
//              "$\\big(a(1-\\frac{y}{b}-\\frac{z}{c}), y\\big)$") ;
          
     }
}

