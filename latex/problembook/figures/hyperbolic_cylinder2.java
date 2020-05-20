                  /*  File:  hyperbolic_cylinder2.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class hyperbolic_cylinder2 extends Template {

     static {templateClass = new hyperbolic_cylinder2() ; }

     public void setup() {
          filePrefix="hyperbolic_cylinder2";//used as the prefix for the ps and lbl files
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 0.7*1.5 ;   // in inches
          ysize = 1.2*1.5 ;   // in inches
          xmin = -50 ;
          xmax = 90 ;
          ymin = -120 ;
          ymax = 120 ;
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
          fLine(15,0, 100,0) ;
          fLine(15,0,  15,100) ;



          String Blue = "0 0.53333 0.8 setrgbcolor  " ;
          String Black = "0 0 0 1 setcmykcolor  " ;
          canvas.append( new fPsWrite(Blue+"\n")) ;

//TOP HALF
          fEnv("lineWidth", 1.5) ;
          {  
             double[] xlist = { 50,  0, -50} ;
             double[] ylist = { 100, 20, 100} ;
             fBezier bez = new fBezier(xlist, ylist, 3, OPEN) ;
             canvas.append(bez) ;
          }
          {  
             double[] xlist = { 80,  30, -20} ;
             double[] ylist = { 100, 20, 100} ;
             fBezier bez = new fBezier(xlist, ylist, 3, OPEN) ;
             canvas.append(bez) ;
          }
          fLine(80, 100, 50, 100) ;
          fLine(-50, 100, -20, 100) ;
          fEnv("psFillGray", 1.0) ;
          {  
             double[] xlist = { 30,  30, 16.0, 14.6} ;
             double[] ylist = { 10,  30, 33.4, 31.2} ;
             fPolygon(xlist,ylist,4,FILLED) ;
          }
          fEnv("psFillGray", 0.0) ;
          fEnv("lineWidth", 0.5) ;
          canvas.append( new fPsWrite("[3 3] 2 setdash\n")) ;
          {  
             double[] xlist = { 80,  30, -20} ;
             double[] ylist = { 100, 20, 100} ;
             fBezier bez = new fBezier(xlist, ylist, 3, OPEN) ;
             canvas.append(bez) ;
          }
          canvas.append( new fPsWrite("[ ] 0 setdash\n")) ;
          fLine(0, 20,  30, 20) ;


////  BOTTOM HALF

          fEnv("lineWidth", 1.5) ;
          {  
             double[] xlist = { 50,  0, -50} ;
             double[] ylist = { -100, -20, -100} ;
             fBezier bez = new fBezier(xlist, ylist, 3, OPEN) ;
             canvas.append(bez) ;
          }
          {  
             double[] xlist = { 80,  30, -20} ;
             double[] ylist = { -100, -20, -100} ;
             fBezier bez = new fBezier(xlist, ylist, 3, OPEN) ;
             canvas.append(bez) ;
          }
          fLine(80, -100, 50, -100) ;
          fLine(-50, -100, -20, -100) ;
          fEnv("psFillGray", 1.0) ;
          {  
             double[] xlist = { 30,  30, 16.0, 14.6} ;
             double[] ylist = { -10,  -30, -33.4, -31.2} ;
             fPolygon(xlist,ylist,4,FILLED) ;
          }
          fEnv("psFillGray", 0.0) ;
          fEnv("lineWidth", 0.5) ;
          canvas.append( new fPsWrite("[3 3] 2 setdash\n")) ;
          {  
             double[] xlist = { 80,  30, -20} ;
             double[] ylist = { -100, -20, -100} ;
             fBezier bez = new fBezier(xlist, ylist, 3, OPEN) ;
             canvas.append(bez) ;
          }
          canvas.append( new fPsWrite("[ ] 0 setdash\n")) ;
          fLine(0, -20,  30, -20) ;




     }
}


