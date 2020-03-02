package com.udaky.animate;
import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.Node;
import javafx.util.Duration;


/***
 * Base Class Takes Node and animation duration
 * */

public class ThreadedTransitions {

    /**
     * This is an animations class Extension to the JavaFx animation
     * allowing one's to apply multiple Animations to the  particular Node
     * this is version 1.0
     * of this library
     * Animation's which are possible till now is
     * 1. FadeOut
     * 2. SlideFromLeft
     * 3. SlideFromRight
     * ComingSoon
     * 4.FadeIn
     * 5.ZoomIn
     * 6.ZoomOut
     * @createdBy  AkashKumarYadav copyright@2020
     */

        private   Node _node;


        public ThreadedTransitions(Node node){
            this._node = node;

        }

        /**
         * the following method is to provide a threaded animation which can run parallel
         * to another animation's this is only a extension to the javaFX library
         * @createdBy AkashKumarYadav
         * Below Functions extends <strong>Thread class</strong>
         * and User only has to make call to the Following Functions to make the animation's work
         * @Note: If user wants to make multiple animations on single node
         * then just make call to multiple animations functions the thread will automatically
         * handle that for you no need to Create Thread By YourSelf
         *

         * **/

        /**
         * Fade in Method take two positional arguments From intensity to Intensity
         * **/
        public void fadeIn(Integer from,Integer to,Integer time){
            class FadeIn extends  Thread{
                private Integer _time;
                private Integer _from;
                private Integer _to;

                public FadeIn(Integer from, Integer to) {
                    this._from = from;
                    this._to = to;
                    _time = time;
                }

                public void run(){
                    FadeTransition transition = new FadeTransition();
                    transition.setDuration(Duration.millis(_time));
                    transition.setFromValue(_from);
                    transition.setToValue(_to);
                    transition.setNode(_node);
                    transition.play();
                }
            }
            FadeIn fadein = new FadeIn(from,to);
            fadein.start();
        }



        /** slide from right method **/
        public void slideFromRight(Integer time){

            class SlideFromRight extends Thread{
                private Integer _time;
                public void run(){
                    _time = time;
                    // instantiates new Transition object
                    TranslateTransition transition = new TranslateTransition();
                    //take time from the parent class Transition
                    transition.setDuration(Duration.millis(_time));
                    transition.setFromX(_node.getLayoutX()+_node.getScene().getWidth());
                    transition.setFromY(0);
                    transition.setToY(0);
                    transition.setToX(0);
                    transition.setNode(_node);
                    transition.play();

                }
            }
            SlideFromRight slidefromright = new SlideFromRight();
            slidefromright.start();
        }

        /** slide from left method **/
        public void slideFromLeft(Integer time){
            class SlideFromLeft extends Thread{
                private Integer _time;
                public void run(){
                    _time = time;
                    TranslateTransition transition = new TranslateTransition();
                    transition.setDuration(Duration.millis(_time));
                    transition.setFromY(0);
                    transition.setFromX(-(_node.getLayoutX()+_node.getScene().getWidth()));
                    transition.setToX(0);
                    transition.setToY(0);
                    transition.setNode(_node);
                    transition.play();
                }
            }
            SlideFromLeft slidefromleft = new SlideFromLeft();
            slidefromleft.start();
        }


        /**slide from bottom**/
        public void slideFromTop(Integer time){
                class SlideFromTop extends Thread {
                    private Integer _time;
                    SlideFromTop(Integer time){
                        _time = time;
                    }
                    public void run() {
                        TranslateTransition transition = new TranslateTransition();
                        transition.setDuration(Duration.millis(_time));
                        transition.setFromX(0);
                        transition.setFromY(-(_node.getLayoutY() + _node.getScene().getHeight()));
                        transition.setToY(0);
                        transition.setToX(0);
                        transition.setNode(_node);
                        transition.play();
                    }
                }
            SlideFromTop slidefromtop = new SlideFromTop(time);
            slidefromtop.start();
        }


}


