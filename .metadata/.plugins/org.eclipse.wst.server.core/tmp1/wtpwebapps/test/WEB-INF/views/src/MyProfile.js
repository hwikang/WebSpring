import React from 'react';
import faker from 'faker';
import MyDetail from './components/MyDetail';
import MyDetailEdit from './components/MyDetailEdit';

class MyProfile extends React.Component{
    state = {
        name:'',
        age:'',
        like: '',
        job: '',
        des:'',
        img:'',
        display:'MyDetail'
    }
    componentDidMount(){
        this.setState({
            like : ['헬스','맥주','피자','사진','독서','SNS'],
            name :"Yunsung Lee",
            age : "32",
            des : "인연을 가볍게 여기지않아요",
            img : faker.image.avatar() ,
            job : 'Jige Car Driver'
        })
    }

    changeDisplay = () =>{
        console.log("changedisplay operated")
        if(this.state.display==='MyDetailEdit'){
            this.setState({
                display:'MyDetail'
            });
        }else if(this.state.display==='MyDetail'){
            this.setState({
                display:'MyDetailEdit'
            });
        }
        
    }

    render(){
        let display = this.state.display
        console.log('display =', display)
        if(display==='MyDetail'){
            return(
                <div>
                    <MyDetail name={this.state.name} age={this.state.age} des={this.state.des} img={this.state.img}
                    like = {this.state.like} job={this.state.job} changeDisplay={this.changeDisplay}/>
                </div>
            );
        }else if(display==='MyDetailEdit'){
            return(
                <div>
                    <MyDetailEdit  name={this.state.name} age={this.state.age} des={this.state.des} img={this.state.img}
                    like = {this.state.like} job={this.state.job} changeDisplay={this.changeDisplay}/>
                </div>
            );
        }
    }
}

export default MyProfile;