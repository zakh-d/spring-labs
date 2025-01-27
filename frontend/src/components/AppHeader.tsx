import {ReactElement} from "react";
import {Container, Image, Menu} from "semantic-ui-react";

import menu_icon from "../assets/menu_icon.png";
import { NavLink } from "react-router";

const AppHeader = (): ReactElement => {

    return (
        <Menu inverted={true}>
            <Container>
                <Menu.Item>
                    <Image size="mini" src={menu_icon} style={{marginRight: '1.5em'}}/>
                    Simple Workout
                </Menu.Item>
                <Menu.Item as={NavLink} to={'/'}>Home</Menu.Item>
                <Menu.Item as={NavLink} to={'/workouts'}>Workouts</Menu.Item>
            </Container>
        </Menu>
    )
}

export default AppHeader;