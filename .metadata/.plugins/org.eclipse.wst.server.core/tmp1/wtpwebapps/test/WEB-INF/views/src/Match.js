import React from 'react';
import './Match.css'
import ExpiredCheck from './components/ExpiredCheck'
import faker from 'faker'

class Match extends React.Component{
    state = {
        name:'',
        age:'',
        like: '',
        job: '',
        des:'',
        img:'',
    }
    componentDidMount(){
        this.setState({
            like : ['헬스','독서','삼겹살','소주','자기계발'],
            name :"Hwi kang",
            age : "28",
            des : "안녕하세요 자연스러운 만남 추구해요 자만추 Baby",
            img : faker.image.avatar() ,
            job : 'Programmer'
        })
    }

    render(){
        return(
            <div>
         
                 <ExpiredCheck name={this.state.name} age={this.state.age} des={this.state.des} img={this.state.img}
                like = {this.state.like} job={this.state.job}/>

            </div>

        )
    }
}

export default Match;