import React from 'react';

class PropCheck extends React.Component{

    render(){
        return(
            <div>

            </div>
        );
    }
}

PropCheck.defaultProps = {
    propString : "Some String",
    propNumber : 10,
    propBool : true,
    propArray : [1,2,3,4],
    propObject : {
        fld1 : "First fld",
        fld2 : "Second fld"
    },
    propFunc : function (p) {return p;}


}

export default PropCheck;