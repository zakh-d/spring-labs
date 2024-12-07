import { ReactElement } from "react";
import { Link } from "react-router";
import { Container, Grid, Header, List, Segment } from "semantic-ui-react";
import { getWorkoutListRoute } from "../utils/routes";

const AppFooter = (): ReactElement => {
    return (
        <Segment inverted vertical style={{ padding: '5em 0em', marginTop: '5em' }}>
            <Container>
                <Grid divided inverted stackable>
                <Grid.Row>
                    <Grid.Column width={3}>
                    <Header inverted as='h4' content='About' />
                    <List link inverted>
                        <List.Item as='a'>Contact Us</List.Item>
                        <List.Item as='a'>Simple Workout Plans</List.Item>
                    </List>
                    </Grid.Column>
                    <Grid.Column width={3}>
                    <Header inverted as='h4' content='Services' />
                    <List link inverted>
                        <List.Item as={Link} to={getWorkoutListRoute()}>Workout List</List.Item>
                        <List.Item as='a'>How To Access</List.Item>
                        <List.Item as='a'>Favorite X-Men</List.Item>
                    </List>
                    </Grid.Column>
                    <Grid.Column width={7}>
                    <Header as='h4' inverted>
                        Simple Workout 
                    </Header>
                    <p>
                        We make sure your workout is simple and easy to follow.
                    </p>
                    </Grid.Column>
                </Grid.Row>
                </Grid>
            </Container>
        </Segment>
    );
}

export default AppFooter;