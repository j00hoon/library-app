import { useOktaAuth } from "@okta/okta-react";
import { Link } from "react-router-dom";

export const Heroes = () => {

    const { authState } = useOktaAuth();




  return (
    <div>
        <div className="d-none d-lg-block">
            <div className="row g-0 mt-5">
                <div className="col-sm-6 col-md-6">
                    <div className="col-image-left"></div>
                </div>

                <div className="col-4 col-md-4 container d-flex justify-content-center align-items-center">
                    <div className="ml-2">
                        <h1>What have you been raeading?</h1>
                        <p className="lead">
                            Want to learn new skills or something else?
                        </p>
                        {authState?.isAuthenticated ?
                            <Link type="button" className='btn main-color btn-lg text-white' to='search'>Explore top books</Link>
                            :
                            <Link className="btn main-color btn-lg text-white" to='/login'>
                                Sign up
                            </Link>
                        }
                    </div>
                </div>

            </div>

            <div className='row g-0'>
                <div className='col-4 col-md-4 container d-flex justify-content-center align-items-center'>
                    <div className='ml-2'>
                        <h1>Our collection is always changing</h1>
                        <p className='lead'>
                            Try to check in daily
                        </p>
                    </div>
                </div>
                <div className='col-sm-6 col-md-6'>
                    <div className='col-image-right'></div>
                </div>
            </div>

        </div>

        {/* Mobile Heroes */}
        <div className='d-lg-none'>
            <div className='container'>
                <div className='m-2'>
                    <div className='col-image-left'>
                        <div className='mt-2'>
                            <h1>What have you been raeading?</h1>
                            <p className="lead">
                                Want to learn new skills or something else?
                            </p>
                            {authState?.isAuthenticated ? 
                                <Link type="button" className="btn main-color btn-lg text-white" to='search'>Explore top books</Link>
                                :
                                <Link className="btn main-color btn-lg text-white" to="/login">
                                    Sign up
                                </Link>
                            }
                        </div>
                    </div>
                </div>
                <div className='m-2'>
                    <div className='col-image-right'></div>
                    <div className='mt-2'>
                        <h1>Our collection is always changing</h1>
                        <p className='lead'>
                            Try to check in daily
                        </p>
                    </div>
                </div>
            </div>
        </div>



    </div>
  );
};
