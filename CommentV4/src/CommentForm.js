import React from 'react';

class CommentForm extends React.Component{


    // custom method to handle submit
    // Every event handler function receives an event(JS) object
    _handleSubmit(event){
        // prevent the default behavior of submit button
        event.preventDefault();

        // access the form data 
        // this._author (DOM)
        // this._author = document.getElementById('auth');
        let author = this._author.value;
        let comment = this._comment.value;
        let tag = this._tag.value;

        // can place validation logic

        this._author.value = "";
        this._comment.value = "";
        this._tag.value = "";
        // propagate the info back to parent (using prop method)
        this.props.addComment(author, comment, tag);
    }

    render(){
        return(
            <div>
                <form onSubmit={this._handleSubmit.bind(this)} >
                    <label>Join the discussion</label>
                    <br/>
                    {/*
                    <input placeholder="Author" id='auth' ref={function(input){
                                                        // logic for renderring eg :init with value
                                                        this._author = input;
                                                    }}/>
                                                */}  
                    <input placeholder="Author" 
                           id='auth' 
                           ref={(input)=>this._author = input}/>                                                          
                    <br/>
                    <input placeholder="Comment" ref={(input)=>this._comment = input}/>
                    <br/>
                    <input placeholder="Tag" ref={(input)=>this._tag = input}/>
                    <br/>
                    <button type="submit">Post Comment</button>
                </form>
            </div>
        );
    }
}

export default CommentForm;