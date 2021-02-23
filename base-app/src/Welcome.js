import React from 'react';

class Welcome extends React.Component{
    // every component class must implement render method
    // output of component
    render(){  // JSX : Javascript & XML
        var current = new Date();
        var names = ["First", "Second", "Third"];
        return(
            <div>
                <h2>Welcome All</h2>
                <h3>Current Time {current.toTimeString()}</h3>
                <ul>
                    {names.map(name => <li>{name}</li>)}
                </ul>
            </div>
        );
    }
}

export default Welcome;