                  /*  File:  domainSwitchb.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class domainSwitchb extends Template {

     static {templateClass = new domainSwitchb() ; }

     public void setup() {
          filePrefix = "domainSwitchb" ;  
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 1.5 ;    
          ysize = 1.5 ;  
          xmin = -0.1 ;
          xmax =  1.2 ;
          ymin = -0.1 ;
          ymax =  1.2 ;
          topmargin = 0.1 ;   // in inches
          bottommargin = 0.1 ;   // in inches
          leftmargin = 0.0 ;   // in inches
          rightmargin = 0 ;   // in inches
          useZoom = true ;
          useDrag = true ;
          showCoords = true ;
          showCanvasBoundary = true ;   
     }
     
     public  void prepareFigure(Figure canvas) {
          ;
          double x = 0.5 ; double X = 0.7 ; double XX =0.85 ;
          {fEnv("psFillGray", 0.9) ;
           double[] xlist = { x,   x,   X, 1, 1} ;
           double[] ylist = { 0, x*x, X*X, 1, 0} ;
           fPolygon(xlist, ylist, 5, FILLED) ;
           }
          {fEnv("lineWidth", 1.5) ;
           double[] xlist = { x,    x, 1, 1} ;
           double[] ylist = { x*x,  0, 0, 1} ;
           fPolygon(xlist, ylist, 4, OPEN) ;
           fCurve("[t, t*t]",1, x,1, OPEN) ;
           }
           fEnv("psFillGray", 1.0) ;
           fCurve("[t, t*t]",1, 0,1, FILLED) ;
          {fEnv("psFillGray", 0.6) ;
           double[] xlist = {XX-0.03, XX-0.03, XX+0.03, XX+0.03} ;
           double[] ylist = {      0,   XX*XX,   XX*XX, 0} ;
           fPolygon(xlist, ylist, 4, FILLED) ;
           }

          fEnv("lineWidth", 0.5) ;

//          canvas.append( new fPsWrite("[3 3] 0.0 setdash\n")) ;
          fLine(x,ymax-0.05,x,ymin) ;
          fLine(1,ymax-0.05,1,ymin) ;
          fCurve("[t, t*t]",1, xmin,1.07, OPEN) ;
//          canvas.append( new fPsWrite("[ ] 0 setdash\n")) ;



          fLine(xmin,0,xmax,0) ;
          fLine(0,ymin,0,ymax) ;
          fTeXlabel(xmax+0.05, 0, "lc", "$y$") ;
          fTeXlabel(0,ymax+0.05, "bc", "$z$") ;
          fTeXlabel(1.1,1.07*1.07, "cl", "$z=y^2$") ;
          fTeXlabel(x,ymin-0.05, "tc", "$y=x$") ;
          fTeXlabel(1,ymin-0.02, "tc", "$y=1$") ;

          fTeXlabel(x+0.2, 0.15, "cc", "$D_x$") ;
     }
}

