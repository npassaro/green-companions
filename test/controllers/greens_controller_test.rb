require 'test_helper'

class GreensControllerTest < ActionDispatch::IntegrationTest
  setup do
    @green = greens(:green_one)
  end

  test "should get index" do
    get greens_url
    assert_response :success
  end

  test "should get new" do
    get new_green_url
    assert_response :success
  end

  test "should create green" do
    assert_difference('Green.count') do
      post greens_url, params: {
        green: {
          name: "#{@green.name}new",
          description: @green.description,
          sow_period: @green.sow_period,
          grow_period: @green.grow_period,
          harvest_period: @green.harvest_period
        }
      }
    end

    assert_redirected_to green_url(Green.last)
  end

  test "should show green" do
    get green_url(@green)
    assert_response :success
  end

  test "should get edit" do
    get edit_green_url(@green)
    assert_response :success
  end

  test "should update green" do
    patch green_url(@green), params: { green: { description: @green.description, grow_period: @green.grow_period, harvest_period: @green.harvest_period, name: @green.name, sow_period: @green.sow_period } }
    assert_redirected_to green_url(@green)
  end

  test "should destroy green" do
    assert_difference('Green.count', -1) do
      delete green_url(@green)
    end

    assert_redirected_to greens_url
  end
end
