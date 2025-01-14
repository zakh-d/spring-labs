import {ReactElement} from "react";
import AppHeader from "./AppHeader.tsx";
import { Outlet } from "react-router";
import AppFooter from "./AppFooter.tsx";

const App = (): ReactElement => {
    return (
        <>
            <AppHeader/>
            <Outlet/>
            <AppFooter/>
        </>
    )
}

export default App
