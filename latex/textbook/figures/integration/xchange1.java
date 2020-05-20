                  /*  File:  xchange1.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class xchange1 extends Template {

     static {templateClass = new xchange1() ; }

     public void setup() {
          filePrefix = "xchange1" ;  
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 3.2*0.6 ;    
          ysize = 3.2*0.6 ;  
          xmin = -1 ;
          xmax =  2.2 ;
          ymin = -1 ;
          ymax =  2.2 ;
          topmargin = 0.2 ;   // in incheslightly shaded
          bottommargin = 0.0 ;   // in inches
          leftmargin = 0.0 ;   // in inches
          rightmargin = 0 ;   // in inches
          useZoom = true ;
          useDrag = true ;
          showCoords = true ;
          showCanvasBoundary = true ;   
     }
     
     public  void prepareFigure(Figure canvas) {
          double th = -135*Math.PI/180 ;
          double x0 = Math.cos(th) ;
          double x1 = Math.sin(th) ;

          double y = 1.0 ;
          double xm = 0.5*(2-y) ; double zm = 2-y ;
          double X0 = y ; double Y0 = 0 ; 
          double X1 =xm*x0 + y ; double Y1 = xm*x1 ; 
          double X2 =xm*x0 + y ; double Y2 = xm*x1 + zm ; 
          double X3 = y        ; double Y3 = zm ; 




          {fEnv("psFillGray", 0.7) ;
           double[] xlist = {X0, X1, X2, X3} ;
           double[] ylist = {Y0, Y1, Y2, Y3} ;
           fPolygon(xlist, ylist, 4, FILLED) ;
           }
//          fEnv("lineWidth", 1.0) ;
//          fLine(1,0,0,1) ;
//          {fEnv("psFillGray", 0.7) ;
//           double[] xlist = {x0  , x0+1, 1} ;
//           double[] ylist = {x1+1, x1,   1} ;
//           fPolygon(xlist, ylist, 3, FILLED) ;
//           }
//          fLine(0,1,1,1) ;
//          fLine(1,0,1,1) ;
//          fLine(0,1,x0,x1+1) ;
//          fLine(1,1,x0,x1+1) ;
//          fLine(x0,x1+1,x0+1,x1) ;
//          fLine(1,0,x0+1,x1) ;
//          fLine(1,1,x0+1,x1) ;

          fEnv("lineWidth", 0.5) ;
          fLine(1,0,xmax,0) ;
          fLine(0,1,0,ymax) ;
          double f = 0.3 ;
          fLine(f*xmax*x0*0.75, f*xmax*x1*0.75, xmax*x0*0.75, xmax*x1*0.75) ;
          canvas.append( new fPsWrite("[2 2] 0.0 setdash\n")) ;
          fLine(0,0,1,0) ;
          fLine(0,0,0,1) ;
          fLine(0,0, f*xmax*x0*0.75, f*xmax*x1*0.75) ;
          canvas.append( new fPsWrite("[ ] 0 setdash\n")) ;
          fTeXlabel(xmax+.1,0, "lc", "$y$") ;
          fTeXlabel(0,ymax+.1, "bc", "$z$") ;
          fTeXlabel(xmax*0.75*x0, xmax*0.75*x1, "tr", "$x$") ;
          
     }
}

